package ink.gfwl.util.letsencrypt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 来此加密配置
 * @author jianpòlan
 * @version 1.0
 **/
@Data
@ConfigurationProperties(
        prefix = "peak.lets",
        ignoreInvalidFields = true
)
public class LetsProperties {

    /**
     * token
     */
    private String token;

    /**
     * 用户名
     */
    private String user;

}
