package ink.gfwl.sample.config;

/**
 * 常量
 * @author jianpòlan
 * @version 1.0
 **/
public interface Produce {

    /**
     * 短信发送
     */
    String queue_send_sms = "gfwl.send";

    String exchange_send_sms = "exchange.gfwl.send";

}
