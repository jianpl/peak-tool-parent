package ink.gfwl.pay.ali;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import ink.gfwl.common.lang.Affirm;
import ink.gfwl.pay.properties.AliPayProperties;
import ink.gfwl.pay.ali.model.AlipayRequest;
import ink.gfwl.pay.ali.model.RefundRequest;
import ink.gfwl.pay.base.CallbackParams;
import ink.gfwl.pay.base.PaymentResponse;
import ink.gfwl.pay.exception.PayException;
import ink.gfwl.pay.util.PayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Alipay
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class AliPayUtil {

    @Autowired(required = false)
    private AliPayProperties aliPayProperties;

    private AlipayClient getAlipayClient(){
        return new DefaultAlipayClient(aliPayProperties.getGetWay(), aliPayProperties.getAppId(), aliPayProperties.getPrivateKey(),"json","UTF-8", aliPayProperties.getPubicKey(),"RSA2");
    }

    /**
     * APP预支付处理
     * @param paymentRequest {@link ink.gfwl.pay.ali.model.AlipayRequest}
     * @return {@link ink.gfwl.pay.base.PaymentResponse}
     */
    public PaymentResponse appPrepare(AlipayRequest paymentRequest) {
        Affirm.isNull(paymentRequest, ()->new PayException(100));
        PaymentResponse paymentResponse = new PaymentResponse();
        AlipayClient alipayClient = getAlipayClient();
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(paymentRequest.getBody());
        model.setSubject(paymentRequest.getBody());
        model.setOutTradeNo(paymentRequest.getTradeNo());
        model.setTimeoutExpress("30m");
        model.setTotalAmount(String.format("%.2f",paymentRequest.getAmount().doubleValue()));
        model.setProductCode("QUICK_MSECURITY_PAY");
        if(paymentRequest.getOtherParams() != null && paymentRequest.getOtherParams() instanceof ExtendParams){
            model.setExtendParams((ExtendParams)paymentRequest.getOtherParams());
        }
        request.setBizModel(model);
        request.setNotifyUrl(paymentRequest.getCallbackUrl());
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            String body = response.getBody();//就是orderString 可以直接给客户端请求，无需再做处理。
            paymentResponse.setOrderStr(body);
            paymentResponse.setSuccess(true);
            return paymentResponse;
        } catch (AlipayApiException e) {
            throw new PayException(104, e.getMessage());
        }
    }

    /**
     * 支付宝支付退款
     * @param refundRequest 退款参数
     */
    public AlipayTradeRefundResponse refund(RefundRequest refundRequest) throws AlipayApiException {
        AlipayClient alipayClient = getAlipayClient();
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("out_trade_no",refundRequest.getTradeNo());
        jsonObject.put("trade_no",refundRequest.getOutTradeNo());
        jsonObject.put("refund_amount",refundRequest.getAmount());
        request.setBizContent(jsonObject.toJSONString());
        return alipayClient.execute(request);
    }

    /**
     * 获取回调参数
     * @param request HttpServletRequest
     * @return CallbackParams
     */
    public CallbackParams getCallback(HttpServletRequest request){
        Map<String, String> params = PayUtil.alipayCallback(request);
        try {
            boolean flag = AlipaySignature.rsaCheckV1(params, aliPayProperties.getPubicKey(), "UTF-8", "RSA2");
            if(flag){
                //更多参数详见： https://opendocs.alipay.com/open/204/105301/
                //商户订单号。原支付请求的商户订单号。
                String trade_no = params.get("out_trade_no");
                //支付宝交易号。
                String out_trade_no = params.get("trade_no");
                //交易状态。交易目前所处的状态
                //WAIT_BUYER_PAY	交易创建，等待买家付款。
                //TRADE_CLOSED	未付款交易超时关闭，或支付完成后全额退款。
                //TRADE_SUCCESS	交易支付成功。
                //TRADE_FINISHED	交易结束，不可退款。
                String trade_status = params.get("trade_status");
                CallbackParams callbackParams = new CallbackParams();
                callbackParams.setOutTradeNo(out_trade_no);
                callbackParams.setTradeNo(trade_no);
                callbackParams.setTradeStatus("TRADE_SUCCESS".equals(trade_status));
                callbackParams.setCallback(JSONObject.toJSONString(params));
                return callbackParams;
            }else{
                throw new PayException(105);
            }
        }catch (Exception e){
            throw new PayException(104, e.getMessage());
        }
    }


}
