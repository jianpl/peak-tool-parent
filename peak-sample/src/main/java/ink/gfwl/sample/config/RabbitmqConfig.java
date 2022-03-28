package ink.gfwl.sample.config;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author jianpòlan
 * @version 1.0
 **/
@SpringBootConfiguration
public class RabbitmqConfig {

    @Bean
    public Queue sendSms() {
        return new Queue(Produce.queue_send_sms);
    }

    // 准备一个交换机
    @Bean
    public TopicExchange exchangeFanout() {
        return new TopicExchange(Produce.exchange_send_sms);
    }

    // 将交换机和队列进行绑定
    @Bean
    public Binding bindingExchange() {
        return BindingBuilder.bind(sendSms()).to(exchangeFanout()).with(Produce.queue_send_sms);
    }

}
