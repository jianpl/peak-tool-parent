package ink.gfwl.example;

import ink.gfwl.captcha.config.EnableCaptcha;
import ink.gfwl.oss.config.EnableOss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jianpòlan
 * @version 1.0
 **/
@EnableOss
@EnableCaptcha
@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

}
