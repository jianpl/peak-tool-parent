package com.peak.sms.base;

import com.peak.sms.model.MessageSendRequest;

/**
 * 短信接口
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public interface Messages {

    String sendMessage(MessageSendRequest messageSendRequest);

}
