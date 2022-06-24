package ink.gfwl.pay.wx;

import ink.gfwl.common.lang.Affirm;
import ink.gfwl.common.lang.ObjectUtils;
import ink.gfwl.pay.base.CallbackParams;
import ink.gfwl.pay.base.PaymentResponse;
import ink.gfwl.pay.exception.PayException;
import ink.gfwl.pay.properties.WxPayProperties;
import ink.gfwl.pay.util.PayUtil;
import ink.gfwl.pay.wx.model.WxPayRequest;
import ink.gfwl.pay.wx.model.WxRefundRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.protocol.https.DefaultHostnameVerifier;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.HashMap;

/**
 * weixin pay
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class WxPayUtil {

    @Autowired(required = false)
    private WxPayProperties wxPayProperties;

    //请求器的配置
    private RequestConfig requestConfig;

    //HTTP请求器
    private CloseableHttpClient httpClient;

    /**
     * 微信支付
     * @param paymentRequest 支付参数 {@link WxPayRequest}
     * @return {@link PaymentResponse}
     */
    public PaymentResponse appPrepare(WxPayRequest paymentRequest) {
        Affirm.isNull(paymentRequest, ()->new PayException(100));
        PaymentResponse paymentResponse = new PaymentResponse();
        try {
            String s = appPayment(paymentRequest);
            paymentResponse.setSuccess(true);
            paymentResponse.setOrderStr(s);
        } catch (Exception e) {
            throw new PayException(104);
        }
        return paymentResponse;
    }

    /**
     * 申请退款
     * @param wxRefundRequest 退款参数
     * @param instream 证书流
     * 微信文档：https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_4&index=6
     */
    public String refund(WxRefundRequest wxRefundRequest, InputStream instream) throws Exception {
        HashMap<String, String> param = new HashMap<>();
        param.put("appid", wxPayProperties.getAppId());
        param.put("mch_id", wxPayProperties.getMchId());
        param.put("nonce_str", String.valueOf(System.currentTimeMillis()));
        param.put("out_trade_no", wxRefundRequest.getTradeNo());
        param.put("out_refund_no", wxRefundRequest.getOutRefundNo());
        param.put("total_fee", String.valueOf(wxRefundRequest.getTotalAmount().multiply(BigDecimal.valueOf(100)).intValue()));
        param.put("refund_fee", String.valueOf(wxRefundRequest.getAmount().multiply(BigDecimal.valueOf(100)).intValue()));
        param.put("notify_url", wxRefundRequest.getNotifyUrl());
        param.put("sign", PayUtil.getSignature(param, wxPayProperties.getApiKey()));
        String paymentParam = ObjectUtils.mapToXML(param);
        return this.httpsRequest(paymentParam, instream);
    }


    private String appPayment(WxPayRequest paymentBody) throws Exception {
        String paymentParam = wxAppParamGenerate(paymentBody);
        return PayUtil.httpsRequest(wxPayProperties.getPayUrl(), paymentParam);
    }

    private String wxAppParamGenerate(WxPayRequest paymentBody) throws Exception {
        HashMap<String, String> param = new HashMap<>();
        param.put("appid", wxPayProperties.getAppId());
        param.put("body", paymentBody.getBody());
        param.put("mch_id", wxPayProperties.getMchId());
        param.put("out_trade_no", paymentBody.getTradeNo());
        param.put("product_id", paymentBody.getProductId());
        param.put("spbill_create_ip", paymentBody.getIpAddress());
        param.put("trade_type", "APP");
        param.put("total_fee", String.valueOf(paymentBody.getAmount().intValue()));
        param.put("sign", PayUtil.getSignature(param, wxPayProperties.getApiKey()));
        return ObjectUtils.mapToXML(param);
    }

    /**
     * 获取回调参数
     * @param request 支付参数
     * @return 结果
     */
    public CallbackParams getCallback(HttpServletRequest request){
        return PayUtil.getCallback(request, wxPayProperties.getApiKey());
    }

    private String httpsRequest(String xmlObj, InputStream instream){
        //加载证书
        try {
            initCert(instream);
        }catch (Exception e){
            e.printStackTrace();
        }
        String result = null;
        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/secapi/pay/refund");
        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(xmlObj, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);
        //设置请求器的配置
        httpPost.setConfig(requestConfig);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpPost.abort();
        }
        return result;
    }

    private void initCert(InputStream instream) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {
        //拼接证书的路径
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        //加载本地的证书进行https加密传输
        try {
            keyStore.load(instream, wxPayProperties.getMchId().toCharArray()); //加载证书密码，默认为商户ID
        } catch (CertificateException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, wxPayProperties.getMchId().toCharArray())  //加载证书密码，默认为商户ID
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory ssl = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                new DefaultHostnameVerifier());

        httpClient = HttpClients.custom()
                .setSSLSocketFactory(ssl)
                .build();
        //根据默认超时限制初始化requestConfig
        //连接超时时间，默认10秒
        int socketTimeout = 10000;
        //传输超时时间，默认30秒
        int connectTimeout = 30000;
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

    }



}
