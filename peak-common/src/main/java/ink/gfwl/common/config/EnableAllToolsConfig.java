package ink.gfwl.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * @author jianpòlan
 * @version 1.0
 **/
@Configuration
@ComponentScan(value = {
        "ink.gfwl"
})
public class EnableAllToolsConfig { }
