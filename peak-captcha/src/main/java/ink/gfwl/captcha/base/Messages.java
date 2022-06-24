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

    /**
     * 发送短信
     * @param messageSendRequest 参数
     * @return 结果
     */
    String sendMessage(MessageSendRequest messageSendRequest);
}
