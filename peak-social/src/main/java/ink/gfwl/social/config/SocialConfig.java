package ink.gfwl.social.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * enable pay config
 * @author jianpòlan
 * @version 1.0
 **/
@Configuration
@ComponentScan(value = {"ink.gfwl.social"})
@ConfigurationPropertiesScan(basePackages = {"ink.gfwl.social"})
public class SocialConfig {
}
