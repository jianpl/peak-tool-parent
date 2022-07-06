package ink.gfwl.jd.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * @author jianpòlan
 * @version 1.0
 **/
@Configuration
@ComponentScan(value = {
        "ink.gfwl.jd"
})
@EnableConfigurationProperties(value = {JdConfig.class})
public class EnableAllToolsConfig { }