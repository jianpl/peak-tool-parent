package ink.gfwl.example;

import ink.gfwl.captcha.AliYunMessageUtil;
import ink.gfwl.captcha.model.AliYunSendRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class SendSmsService {

    private final AliYunMessageUtil aliYunMessageUtil;

    public SendSmsService(AliYunMessageUtil aliYunMessageUtil) {
        this.aliYunMessageUtil = aliYunMessageUtil;
    }

    public void sendAliYunMessage(){
        AliYunSendRequest aliYunSendRequest = new AliYunSendRequest();
        Map<String, String> params = new HashMap<>();
        params.put("code", "8888");
        aliYunSendRequest.setParams(params);
        aliYunSendRequest.setPhone("手机号");
        aliYunSendRequest.setTemplateId("模板ID");
        String code = aliYunMessageUtil.sendMessage(aliYunSendRequest);
    }
}
