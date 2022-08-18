package ink.gfwl.captcha;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import ink.gfwl.common.lang.Affirm;
import ink.gfwl.captcha.properties.AliSmsProperties;
import ink.gfwl.captcha.base.Messages;
import ink.gfwl.captcha.exception.SmsException;
import ink.gfwl.captcha.model.AliYunSendRequest;
import ink.gfwl.captcha.model.MessageSendRequest;
import org.springframework.stereotype.Component;

/**
 * 阿里云短信发送
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 * <p>url: <a href="https://github.com/jianpl/peak-tool-parent">github</a></p>
 * <a href='https://help.aliyun.com/document_detail/71160.html'>阿里云接口文档</a>
 */
@Component
public class AliYunMessageUtil implements Messages {

    private final AliSmsProperties aliSmsProperties;

    public AliYunMessageUtil(AliSmsProperties aliSmsProperties) {
        this.aliSmsProperties = aliSmsProperties;
    }

    /**
     * 短信发送
     * @param messageSendRequest 短信参数
     * @see AliYunSendRequest
     * @return 短信结果
     */
    @Override
    public String sendMessage(MessageSendRequest messageSendRequest) {
        return this.sendMessage(messageSendRequest, null);
    }

    /**
     * 短信发送(自定义短信配置)
     * @param messageSendRequest 短信参数
     * @param aliSmsProperties 配置参数
     * @return 短信结果
     */
    public String sendMessage(MessageSendRequest messageSendRequest, AliSmsProperties aliSmsProperties){
        aliSmsProperties = aliSmsProperties == null ? this.aliSmsProperties : aliSmsProperties;
        Affirm.isNull(messageSendRequest, ()->new SmsException(500, "参数为空"));
        Affirm.isFalse(messageSendRequest instanceof AliYunSendRequest, ()->new SmsException(501, "参数异常"));
        Affirm.isNull(messageSendRequest.getPhone(), ()->new SmsException(502, "手机号为空"));
        Affirm.isNull(((AliYunSendRequest) messageSendRequest).getParams(), ()->new SmsException(503, "参数为空"));
        Affirm.isNull(((AliYunSendRequest) messageSendRequest).getTemplateId(), ()->new SmsException(504, "模板ID为空"));
        DefaultProfile profile = DefaultProfile.getProfile(aliSmsProperties.getRegionId(), aliSmsProperties.getAccessKeyId(), aliSmsProperties.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", aliSmsProperties.getRegionId());
        request.putQueryParameter("PhoneNumbers", messageSendRequest.getPhone());
        request.putQueryParameter("SignName", aliSmsProperties.getSignName());
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
