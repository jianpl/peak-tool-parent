//package ink.gfwl.jd.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.codec.JsonJacksonCodec;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 分布式锁,同步商品
// */
//@Configuration
//public class RedissonConfig {
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private String port;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Bean
//    public RedissonClient getRedisson(){
//        Config config = new Config();
//        config.setCodec(JsonJacksonCodec.INSTANCE);
//        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
//        return Redisson.create(config);
//    }
//}
//
