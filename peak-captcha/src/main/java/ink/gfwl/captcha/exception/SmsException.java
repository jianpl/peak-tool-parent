package ink.gfwl.captcha.exception;

/**
 * 短信异常
 * @author jianpòlan
 * @version 1.0
 * <p>url: https://github.com/jianpl/peak-tool-parent</p>
 **/
public class SmsException extends RuntimeException{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1795731493416896506L;

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String message;

    /**
     * 构造
     * @param code 错误码
     * @param message 消息
     */
    public SmsException(int code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 错误消息
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 错误码
     * @return code
     */
    public Integer getCode() {
        return code;
    }
}
