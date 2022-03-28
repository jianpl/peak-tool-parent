package ink.gfwl.sms;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.math.Affirm;
import ink.gfwl.common.properties.sms.ZthySmsProperties;
import ink.gfwl.sms.base.Messages;
import ink.gfwl.sms.exception.SmsException;
import ink.gfwl.sms.model.MessageSendRequest;
import ink.gfwl.sms.model.ZthyCustomMessageRequest;
import ink.gfwl.sms.model.ZthyMessageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * 助通短信发送
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class ZthyMessageUtil implements Messages {

    private final RestTemplate restTemplate = new RestTemplate();

    @Resource
    private ZthySmsProperties zthySmsProperties;

    /**
     * 短信发送
     * @param messageSendRequest 发送参数
     * @return 发送结果
     */
    @Override
    public String sendMessage(MessageSendRequest messageSendRequest) {
        Affirm.isNull(messageSendRequest, ()->new SmsException(500, "参数为空"));
        Affirm.isFalse(messageSendRequest instanceof ZthyMessageRequest, ()->new SmsException(501, "参数异常"));
        ZthyMessageRequest zthyMessageRequest = (ZthyMessageRequest)messageSendRequest;
        //请求入参
        JSONObject requestJson = new JSONObject();
        requestJson.put("username", zthySmsProperties.getUsername());
        long tKey = System.currentTimeMillis() / 1000;
        requestJson.put("tKey", tKey);
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex(zthySmsProperties.getPassword().getBytes(StandardCharsets.UTF_8)) + tKey).getBytes(StandardCharsets.UTF_8)));
        requestJson.put("tpId", zthyMessageRequest.getTpId());
        requestJson.put("signature", zthyMessageRequest.getSignature());
        requestJson.put("ext", "");
        requestJson.put("extend", "");
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        record.put("mobile", zthyMessageRequest.getPhone());
        record.put("tpContent", zthyMessageRequest.getParam());
        records.add(record);
        requestJson.put("records", records);
        String urls_tp = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        return restTemplate.postForObject(urls_tp, requestJson.toJSONString(), String.class);
    }

    /**
     * 自定义内容发送
     * @param messageSendRequest 参数
     * @return 结果
     */
    public String sendCustomMessage(ZthyCustomMessageRequest messageSendRequest){
        String urls = "https://api.mix2.zthysms.com/v2/sendSms";
        long tKey = System.currentTimeMillis() / 1000;
        JSONObject json = new JSONObject();
        //账号
        json.put("username", zthySmsProperties.getUsername());
        //密码
        json.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex(zthySmsProperties.getPassword().getBytes(StandardCharsets.UTF_8)) + tKey).getBytes(StandardCharsets.UTF_8)));
        //tKey
        json.put("tKey", tKey + "");
        //手机号
        json.put("mobile", messageSendRequest.getPhone());
        //内容
        json.put("content", messageSendRequest.getContent());
        return restTemplate.postForObject(urls, json.toJSONString(), String.class);
    }


}
