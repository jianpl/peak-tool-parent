import com.alibaba.fastjson.JSONObject;
import ink.gfwl.example.ExampleApplication;
import ink.gfwl.oss.MinioUtil;
import ink.gfwl.oss.properties.MinioProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@Slf4j
@SpringBootTest(classes = {ExampleApplication.class})
public class TestExampleApplication {

    @Resource
    private MinioProperties minioProperties;

    @Resource
    private MinioUtil minioUtil;

    @Test
    public void testMinioOss(){
        log.info(JSONObject.toJSONString(minioProperties));
    }

    @Test
    public void upload(){
        long start = System.currentTimeMillis();
        String path = minioUtil.uploadFile("peak-chat", new File("/Users/alang/Downloads/TencentMeeting_0300000000_3.9.6.413.publish.x86_64.dmg"));
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
        System.out.println(path);
        String bucketPolicy = minioUtil.getBucketPolicy("peak-chat");
        System.out.println(bucketPolicy);
    }

}
