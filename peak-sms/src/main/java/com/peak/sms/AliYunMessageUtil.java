package com.peak.sms;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.peak.common.math.Affirm;
import com.peak.sms.base.Messages;
import com.peak.sms.model.AliYunSendRequest;
import com.peak.sms.model.MessageSendRequest;
import exception.SmsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 阿里云短信发送
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
@Service
public class AliYunMessageUtil implements Messages {

    @Value("${peak.sms.ali.regionId}")
    private String regionId;
    @Value("${peak.sms.ali.accessKeyId}")
    private String accessKeyId;
    @Value("${peak.sms.ali.accessKeySecret}")
    private String accessKeySecret;
    @Value("${peak.sms.ali.signName}")
    private String signName;


    /**
     * 短信发送
     * @param messageSendRequest 短信参数
     * @see AliYunSendRequest
     * @return 短信结果
     */
    @Override
    public String sendMessage(MessageSendRequest messageSendRequest) {
        Affirm.isNull(messageSendRequest, ()->new SmsException(500, "参数为空"));
        Affirm.isFalse(messageSendRequest instanceof AliYunSendRequest, ()->new SmsException(501, "参数异常"));
        Affirm.isNull(messageSendRequest.getPhone(), ()->new SmsException(502, "手机号为空"));
        Affirm.isNull(((AliYunSendRequest) messageSendRequest).getParams(), ()->new SmsException(503, "参数为空"));
        Affirm.isNull(((AliYunSendRequest) messageSendRequest).getTemplateId(), ()->new SmsException(504, "模板ID为空"));
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", messageSendRequest.getPhone());
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", ((AliYunSendRequest) messageSendRequest).getTemplateId());
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(((AliYunSendRequest) messageSendRequest).getParams()));
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getData();
        } catch (ClientException e) {
            e.printStackTrace();
            throw new SmsException(500, e.getMessage());
        }
    }
}
