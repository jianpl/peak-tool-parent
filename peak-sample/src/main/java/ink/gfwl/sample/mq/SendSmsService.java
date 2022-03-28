package ink.gfwl.sample.mq;

import com.rabbitmq.client.Channel;
import ink.gfwl.sample.config.Produce;
import ink.gfwl.sample.web.SendSmsModel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/

@Component
public class SendSmsService {

    @RabbitListener(queues = {Produce.queue_send_sms})
    public void sendLoginSms(Message message, SendSmsModel sendSmsModel, Channel channel) throws IOException {
        System.out.println("发送号码为："+sendSmsModel.getPhone());
        System.out.println("发送内容为："+sendSmsModel.getContent());
        MessageProperties messageProperties = message.getMessageProperties();
        System.out.println("消息处理完成---------------------------------");
        //消息顺序，自增
        long deliveryTag = messageProperties.getDeliveryTag();
        System.out.println(deliveryTag);
        //回复，签收消息, fasle表示只签收当前消息，true签收所有
        channel.basicAck(deliveryTag, false);
    }

}
