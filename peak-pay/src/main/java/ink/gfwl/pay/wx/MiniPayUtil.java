package ink.gfwl.pay.wx;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import ink.gfwl.common.lang.ObjectUtils;
import ink.gfwl.pay.base.CallbackParams;
import ink.gfwl.pay.base.PaymentResponse;
import ink.gfwl.pay.exception.PayException;
import ink.gfwl.pay.properties.WxMiniPayProperties;
import ink.gfwl.pay.util.PayUtil;
import ink.gfwl.pay.wx.model.OrderReturnInfo;
import ink.gfwl.pay.wx.model.WxPayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * weixin mini program
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class MiniPayUtil {

    @Autowired(required = false)
    private WxMiniPayProperties wxMiniPayProperties;

    /**
     * <p>预下单</p>
     * <p>JAVA接口文档地址: https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_1</p>
     * <p>小程序文档地址: https://developers.weixin.qq.com/miniprogram/dev/api/payment/wx.requestPayment.html</p>
     * @param paymentBody 支付参数
     * @return 下单结果
     */
    public PaymentResponse miniPrepare(WxPayRequest paymentBody){
        HashMap<String,String> data = new HashMap<>();
        data.put("appid", wxMiniPayProperties.getAppId());//小程序
        data.put("mch_id", wxMiniPayProperties.getMchId());//商户号
        data.put("nonce_str", System.currentTimeMillis()+"");//随机字符串
        data.put("openid", paymentBody.getOpenId());//用户标识
        data.put("body", paymentBody.getBody());//商品描述
        data.put("out_trade_no", paymentBody.getTradeNo());//商户订单号
        data.put("fee_type", "CNY");//
        Integer price = Math.toIntExact(Math.round(paymentBody.getAmount().multiply(BigDecimal.valueOf(100)).intValue()));
        data.put("total_fee",price+"");//标价金额
        data.put("spbill_create_ip", paymentBody.getIpAddress());//终端IP
        data.put("notify_url", paymentBody.getNotifyUrl());//回调地址
        data.put("trade_type", "JSAPI");  //交易类型
        //生成签名
        String signXml;
        try {
            //调用demo里面的sign生成方法
            signXml = generateSignedXml(data);
            String result = PayUtil.httpsRequest(wxMiniPayProperties.getPayUrl(), signXml);
            XStream xStream = new XStream();
            XStream.setupDefaultSecurity(xStream);
            //出于安全考虑，这里必须限制类型，不然会报错
            xStream.allowTypes(new Class[]{OrderReturnInfo.class});
            xStream.alias("xml", OrderReturnInfo.class);

            OrderReturnInfo returnInfo = (OrderReturnInfo)xStream.fromXML(result);
            // 二次签名
            if ("SUCCESS".equals(returnInfo.getReturn_code()) && returnInfo.getReturn_code().equals(returnInfo.getResult_code())) {
                long time = System.currentTimeMillis()/1000;

                //生成签名（官方给出来的签名方法）
                HashMap<String,String> map2 = new HashMap<>();
                map2.put("appId", wxMiniPayProperties.getAppId());
                map2.put("timeStamp", String.valueOf(time));
                //这边的随机字符串必须是第一次生成sign时，微信返回的随机字符串，不然小程序支付时会报签名错误
                map2.put("nonceStr", returnInfo.getNonce_str());
                map2.put("package", "prepay_id=" + returnInfo.getPrepay_id());
                map2.put("signType", "MD5");

                String sign2 = generateSignedXml(map2);
                Map<String,Object> payInfo = new HashMap<>();
                payInfo.put("timeStamp", String.valueOf(time));
                payInfo.put("nonceStr", returnInfo.getNonce_str());
                payInfo.put("prepay_id",returnInfo.getPrepay_id());
                payInfo.put("out_trade_no",paymentBody.getTradeNo());
                payInfo.put("signType", "MD5");
                payInfo.put("paySign", sign2);
                PaymentResponse paymentResponse = new PaymentResponse();
                paymentResponse.setOrderStr(JSONObject.toJSONString(payInfo));
                paymentResponse.setSuccess(true);
                return paymentResponse;
            }
            throw new PayException(104);
        }catch (Exception e) {
            throw new PayException(104, e.getMessage());
        }
    }

    /**
     * 获取回调参数
     * @param request 支付参数
     * @return 结果
     */
    public CallbackParams getCallback(HttpServletRequest request){
        return PayUtil.getCallback(request, wxMiniPayProperties.getApiKey());
    }

    private String generateSignedXml(final HashMap<String, String> data) throws Exception {
        String sign = PayUtil.getSignature(data, wxMiniPayProperties.getApiKey());
        data.put("sign", sign);
        return ObjectUtils.mapToXML(data);
    }

}
