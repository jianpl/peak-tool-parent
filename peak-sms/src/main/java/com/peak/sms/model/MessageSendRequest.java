package com.peak.sms.model;

/**
 * 短信发送参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class MessageSendRequest {

    /**
     * 接收短信手机号
     */
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
