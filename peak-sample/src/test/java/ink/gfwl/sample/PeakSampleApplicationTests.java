package ink.gfwl.sample;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.properties.sms.AliSmsProperties;
import ink.gfwl.common.properties.sms.TencentSmsProperties;
import ink.gfwl.common.properties.sms.ZthySmsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = PeakSampleApplication.class)
public class PeakSampleApplicationTests {

    @Resource
    private AliSmsProperties aliSmsProperties;
    @Resource
    private TencentSmsProperties tencentSmsProperties;
    @Resource
    private ZthySmsProperties zthySmsProperties;

    @Test
    public void test(){
        System.out.println(JSONObject.toJSONString(aliSmsProperties));
        System.out.println(JSONObject.toJSONString(tencentSmsProperties));
        System.out.println(JSONObject.toJSONString(zthySmsProperties));
    }

}
