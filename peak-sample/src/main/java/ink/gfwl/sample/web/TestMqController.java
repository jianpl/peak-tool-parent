package ink.gfwl.sample.web;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.sample.config.Produce;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/mq")
public class TestMqController {

    @Resource
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/test")
    public JSONObject testObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        return jsonObject;
    }

    @GetMapping("/sendMessage")
    public JSONObject sendMessage(){
        SendSmsModel sendSmsModel = new SendSmsModel();
        sendSmsModel.setPhone("13333333333");
        sendSmsModel.setContent("[圭峰网络]你的登录验证码为: 666666");
        rabbitTemplate.convertAndSend(Produce.queue_send_sms, sendSmsModel);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        return jsonObject;
    }

}
