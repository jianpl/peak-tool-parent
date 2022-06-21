package ink.gfwl.sample;

import ink.gfwl.common.properties.sms.ZthySmsProperties;
import ink.gfwl.sms.ZthyGsMessageUtil;
import ink.gfwl.sms.ZthyMessageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@SpringBootTest(classes = PeakSampleApplication.class)
public class SmsTest {

    @Resource
    private ZthyMessageUtil zthyMessageUtil;
    @Resource
    private ZthySmsProperties zthySmsProperties;
    @Resource
    private ZthyGsMessageUtil zthyGsMessageUtil;
    @Test
    public void testZthy(){
//        ZthyCustomMessageRequest zthyCustomMessageRequest = new ZthyCustomMessageRequest();
//        zthyCustomMessageRequest.setContent("【圭峰网络】你的登录验证码为: 3333，请妥善保管");
//        zthyCustomMessageRequest.setPhone("13331130332");
//        String sendCustomMessage = zthyMessageUtil.sendCustomMessage(zthyCustomMessageRequest);
//        System.out.println("发送结果："+sendCustomMessage);
//        ZthyMessageRequest messageRequest = new ZthyMessageRequest();
//        messageRequest.setPhone("13331130332");
//        messageRequest.setSignature("【圭峰网络】");
//        messageRequest.setTpId("54593");
//        JSONObject params = new JSONObject();
//        params.put("valid_code", "326579");
//        messageRequest.setParam(params);
//        String message = zthyMessageUtil.sendMessage(messageRequest);
//        System.out.println(message);

//        ZthyGsMessageRequest zthyGsMessageRequest = new ZthyGsMessageRequest();
//        zthyGsMessageRequest.setContent("he boy, the code is: 89548");
//        zthyGsMessageRequest.setPhone("12035487470");
//        String message = zthyGsMessageUtil.sendGsMessage(zthyGsMessageRequest);
//        System.out.println(message);
        System.out.println(zthyGsMessageUtil.queryGsBalance());
    }

}
