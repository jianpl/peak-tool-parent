package ink.gfwl.pay.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * enable pay config
 * @author jianpòlan
 * @version 1.0
 **/
@Configuration
@ComponentScan(value = {"ink.gfwl.pay"})
@ConfigurationPropertiesScan(basePackages = {"ink.gfwl.pay"})
public class PayConfig {
}
