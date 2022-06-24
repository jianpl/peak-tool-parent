package ink.gfwl.captcha.model;

import java.util.Map;

/**
 * 阿里云短信发送参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class AliYunSendRequest extends MessageSendRequest{

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 参数
     */
    private Map<String, String> params;

    /**
     * Gets the value of templateId
     *
     * @return the value of templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * Sets the templateId
     * <p>You can use getTemplateId() to get the value of templateId</p>
     *
     * @param templateId templateId
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Gets the value of params
     *
     * @return the value of params
     */
    public Map<String, String> getParams() {
        return params;
    }

    /**
     * Sets the params
     * <p>You can use getParams() to get the value of params</p>
     *
     * @param params params
     */
    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
