package ink.gfwl.pay.exception;

/**
 * PayException
 * @author jianpòlan
 * @version 1.0
 **/
public class PayException extends RuntimeException{
    private static final long serialVersionUID = 854601426653619367L;

    private final Integer code;

    private String message;

    public PayException(Integer code){
        this.code = code;
    }

    public PayException(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * Gets the value of code
     *
     * @return the value of code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Gets the value of message
     *
     * @return the value of message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
