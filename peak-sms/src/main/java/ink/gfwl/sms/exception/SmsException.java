package ink.gfwl.sms.exception;

/**
 * 短信异常
 * @author jianpòlan
 * @version 1.0
 * <p>url: https://github.com/jianpl/peak-tool-parent</p>
 **/
public class SmsException extends RuntimeException{

    private final Integer code ;

    private final String message;

    public SmsException(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
