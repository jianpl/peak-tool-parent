package com.peak.sms;

import com.peak.common.math.Affirm;
import com.peak.sms.base.Messages;
import com.peak.sms.model.MessageSendRequest;
import com.peak.sms.model.TencentMessageRequest;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import exception.SmsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 腾讯短信接口
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
@Service
public class TencentMessageUtil implements Messages {

    @Value("${peak.sms.tencent.secretId}")
    private String secretId;
    @Value("${peak.sms.tencent.secretKey}")
    private String secretKey;
    @Value("${peak.sms.tencent.sdkAppId}")
    private String sdkAppId;
    @Value("${peak.sms.tencent.signName}")
    private String signName;

    /**
     * 短信发送
     * @param messageSendRequest 短信参数
     * @see TencentMessageRequest
     * @return 短信结果
     */
    @Override
    public String sendMessage(MessageSendRequest messageSendRequest) {
        Affirm.isNull(messageSendRequest, ()->new SmsException(500, "参数为空"));
        Affirm.isFalse(messageSendRequest instanceof TencentMessageRequest, ()->new SmsException(501, "参数异常"));
        Affirm.isNull(messageSendRequest.getPhone(), ()->new SmsException(502, "手机号为空"));
        Affirm.isNull(((TencentMessageRequest) messageSendRequest).getTemplateParam(), ()->new SmsException(503, "参数为空"));
        Affirm.isNull(((TencentMessageRequest) messageSendRequest).getTemplateId(), ()->new SmsException(504, "模板ID为空"));
        try {
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setConnTimeout(60);
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            SmsClient client = new SmsClient(cred, "ap-guangzhou",clientProfile);
            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppid(sdkAppId);
            req.setSign(signName);
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
