package ink.gfwl.oss.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * enable sms config
 * @author jianpòlan
 * @version 1.0
 **/
@Configuration
@ComponentScan(value = {"ink.gfwl.oss"})
@ConfigurationPropertiesScan(basePackages = {"ink.gfwl.oss"})
public class OssConfig {
}
