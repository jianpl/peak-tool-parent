package ink.gfwl.captcha.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * enable sms
 * @author jianpòlan
 * @version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Import(CaptchaConfig.class)
public @interface EnableCaptcha {
}
