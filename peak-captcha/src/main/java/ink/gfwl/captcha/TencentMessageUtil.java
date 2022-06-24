package ink.gfwl.captcha;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import ink.gfwl.common.lang.Affirm;
import ink.gfwl.captcha.properties.TencentSmsProperties;
import ink.gfwl.captcha.base.Messages;
import ink.gfwl.captcha.exception.SmsException;
import ink.gfwl.captcha.model.MessageSendRequest;
import ink.gfwl.captcha.model.TencentMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 腾讯短信接口
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 * <p>url: https://github.com/jianpl/peak-tool-parent</p>
 */
@Component
public class TencentMessageUtil implements Messages {

    @Autowired(required = false)
    private TencentSmsProperties tencentSmsProperties;




    /**
     * 短信发送
     * @param messageSendRequest 短信参数
     * @see TencentMessageRequest
     * @return 短信结果
     */
    @Override
    public String sendMessage(MessageSendRequest messageSendRequest) {
        return sendMessage(messageSendRequest, null);
    }

    /**
     * 短信发送(自定义短信配置)
     * @param messageSendRequest 短信参数
     * @param tencentSmsProperties 配置参数
     * @return 短信结果
     */
    public String sendMessage(MessageSendRequest messageSendRequest, TencentSmsProperties tencentSmsProperties) {
        tencentSmsProperties = tencentSmsProperties == null ? this.tencentSmsProperties : tencentSmsProperties;
        Affirm.isNull(messageSendRequest, ()->new SmsException(500, "参数为空"));
        Affirm.isFalse(messageSendRequest instanceof TencentMessageRequest, ()->new SmsException(501, "参数异常"));
        Affirm.isNull(messageSendRequest.getPhone(), ()->new SmsException(502, "手机号为空"));
        Affirm.isNull(((TencentMessageRequest) messageSendRequest).getTemplateParam(), ()->new SmsException(503, "参数为空"));
        Affirm.isNull(((TencentMessageRequest) messageSendRequest).getTemplateId(), ()->new SmsException(504, "模板ID为空"));
        try {
            Credential cred = new Credential(tencentSmsProperties.getSecretId(), tencentSmsProperties.getSecretKey());
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setConnTimeout(60);
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            SmsClient client = new SmsClient(cred, "ap-guangzhou",clientProfile);
            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppid(tencentSmsProperties.getSdkAppId());
            req.setSign(tencentSmsProperties.getSignName());
            req.setTemplateID(((TencentMessageRequest) messageSendRequest).getTemplateId());
            String phone = messageSendRequest.getPhone().startsWith("+86") ? messageSendRequest.getPhone() : "+86" + messageSendRequest.getPhone();
            String[] phoneNumberSet = {phone};
            req.setPhoneNumberSet(phoneNumberSet);
            req.setTemplateParamSet(((TencentMessageRequest) messageSendRequest).getTemplateParam());
            SendSmsResponse res = client.SendSms(req);
            return SendSmsResponse.toJsonString(res);
        }catch (Exception e){
            throw new SmsException(500, e.getMessage());
        }
    }
}
