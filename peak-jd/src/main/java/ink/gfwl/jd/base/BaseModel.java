package ink.gfwl.jd.base;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1966476852799319856L;
    /**
     *
     */
    protected boolean success;

    /**
     * 对resultCode的简要说明
     */
    protected String resultMessage;

    /**
     * 业务处理结果编码
     * 5001: 服务异常，请稍后重试
     * 5002: 未知错误
     */
    protected String resultCode;



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
