package ink.gfwl.sample;

import ink.gfwl.captcha.config.EnableCaptcha;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCaptcha
@SpringBootApplication
public class PeakSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeakSampleApplication.class, args);
    }

}
