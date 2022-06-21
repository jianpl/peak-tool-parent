package ink.gfwl.sample;

import ink.gfwl.common.properties.social.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@SpringBootTest(classes = PeakSampleApplication.class)
public class PropertiesTest {

    @Autowired
    private AliLoginProperties aliLoginProperties;
    @Autowired
    private GithubProperties githubProperties;
    @Autowired
    private WxAppProperties wxAppProperties;
    @Autowired
    private WxH5Properties wxH5Properties;
    @Autowired
    private WxMiniProperties wxMiniProperties;
    @Autowired
    private WxWebProperties wxWebProperties;

    @Test
    public void test(){

        System.out.println("支付宝:"+aliLoginProperties);
        System.out.println("GITHUB:"+githubProperties);
        System.out.println("微信APP:"+wxAppProperties);
        System.out.println("微信H5:"+wxH5Properties);
        System.out.println("微信小程序:"+wxMiniProperties);
        System.out.println("微信web:"+wxWebProperties);
    }

}
