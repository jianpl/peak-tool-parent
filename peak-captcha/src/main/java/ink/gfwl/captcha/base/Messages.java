package ink.gfwl.captcha.base;

import ink.gfwl.captcha.model.MessageSendRequest;

/**
 * 短信接口
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 * <p>url: https://github.com/jianpl/peak-tool-parent</p>
 */
public interface Messages {

    String sendMessage(MessageSendRequest messageSendRequest);
}