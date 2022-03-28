package ink.gfwl.sample;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@EnableRabbit //启用
public class PeakSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeakSampleApplication.class, args);
    }

}
