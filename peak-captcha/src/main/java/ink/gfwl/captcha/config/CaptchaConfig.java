package ink.gfwl.captcha.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * enable captcha config
 * @author jianpòlan
 * @version 1.0
 **/
@Configuration
@ComponentScan(value = {"ink.gfwl.captcha"})
@ConfigurationPropertiesScan(basePackages = {"ink.gfwl.captcha"})
public class CaptchaConfig {
}
