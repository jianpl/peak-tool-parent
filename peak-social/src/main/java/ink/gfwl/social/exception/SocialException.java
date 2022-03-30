package ink.gfwl.social.exception;

/**
 * 短信异常
 * @author jianpòlan
 * @version 1.0
 * <p>url: https://github.com/jianpl/peak-tool-parent</p>
 **/
public class SocialException extends RuntimeException{

    private final Integer code ;

    private final String message;

    public SocialException(int code, String message){
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
