package ink.gfwl.sample.thread;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class TheaterOrderJob {

    @Resource
    private RedissonClient redissonClient;

    public void lockTicket(String name) { //例如 影院订票锁座功能 集群环境需要实现分布式锁
        try {
            //采用集群共享锁机制，来解决多应该同时执行定时任务问题
            RLock lock = redissonClient.getLock("redisson_cancel_order");
            boolean b = lock.tryLock(10, TimeUnit.SECONDS);
            //b为 true则代表已获得锁
            if(b) {
                //执行业务逻辑，例如锁座，集群环境下，多个实例 只有得到锁后才能 锁座，同一时间只有一个实例在执行
                //.....
                System.out.println(name);
                lock.unlock();//解锁
            }else{
                //未获得锁执行代码
                //....
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

