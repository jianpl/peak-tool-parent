package ink.gfwl.pay.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * enable pay
 * @author jianpòlan
 * @version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Import(PayConfig.class)
public @interface EnablePay {
}
