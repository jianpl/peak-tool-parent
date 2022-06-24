package ink.gfwl.social.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * enable pay
 * @author jianpòlan
 * @version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Import(SocialConfig.class)
public @interface EnableSocial {
}
