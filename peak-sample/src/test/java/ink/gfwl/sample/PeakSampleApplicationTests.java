package ink.gfwl.sample;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.captcha.properties.AliSmsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PeakSampleApplication.class)
public class PeakSampleApplicationTests {

    @Autowired(required = false)
    private AliSmsProperties aliSmsProperties;

    @Test
    public void test(){
        System.out.println(JSONObject.toJSONString(aliSmsProperties));
    }

}
