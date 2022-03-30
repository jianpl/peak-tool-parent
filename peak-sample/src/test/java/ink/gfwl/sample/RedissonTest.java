package ink.gfwl.sample;

import ink.gfwl.sample.thread.TheaterOrderJob;
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
public class RedissonTest {

    @Resource
    private TheaterOrderJob theaterOrderJob;

    @Test
    public void main() {
        for (int i = 0; i < 200; i++) {
            theaterOrderJob.lockTicket("执行："+ i);
        }
        try {
            Thread.sleep(20000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
