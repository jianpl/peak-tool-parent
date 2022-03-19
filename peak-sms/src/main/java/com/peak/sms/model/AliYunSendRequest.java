package com.peak.sms.model;

import java.util.Map;

/**
 * 阿里云短信发送参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class AliYunSendRequest extends MessageSendRequest{

    private String templateId;

    private Map<String, String> params;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
