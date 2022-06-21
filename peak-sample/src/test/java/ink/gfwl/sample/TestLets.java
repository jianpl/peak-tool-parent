package ink.gfwl.sample;

import ink.gfwl.util.letsencrypt.LetsencryptUtil;
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
public class TestLets {

    @Resource
    private LetsencryptUtil letsencryptUtil;

    @Test
    public void testCertList(){
        System.out.println(letsencryptUtil.certList());
    }

}
