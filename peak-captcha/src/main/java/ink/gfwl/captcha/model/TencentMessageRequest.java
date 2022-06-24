package ink.gfwl.captcha.model;

/**
 * 腾讯云短信发送参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class TencentMessageRequest extends MessageSendRequest{

    private String templateId;

    private String [] templateParam;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String[] getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String[] templateParam) {
        this.templateParam = templateParam;
    }
}
