package ink.gfwl.oss.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * enable oss
 * @author jianpòlan
 * @version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Import(OssConfig.class)
public @interface EnableOss {
}
