package ink.peak.test;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.properties.sms.AliSmsProperties;
import ink.gfwl.common.properties.sms.TencentSmsProperties;
import ink.gfwl.sms.SmsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@SpringBootTest(classes = SmsApplication.class)
public class TestApplication {

    @Resource
    private AliSmsProperties aliSmsProperties;
    @Resource
    private TencentSmsProperties tencentSmsProperties;

    @Test
    public void test(){
        System.out.println(JSONObject.toJSONString(aliSmsProperties));
        System.out.println(JSONObject.toJSONString(tencentSmsProperties));
    }

}
