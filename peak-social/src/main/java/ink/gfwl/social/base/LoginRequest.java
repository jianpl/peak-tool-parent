package ink.gfwl.social.base;


/**
 * 登录请求参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class LoginRequest {

    /**
     * 登录参数
     */
    private String loginCode;

    public LoginRequest() {
    }

    /**
     * 初始化构造
     * @param loginCode 第三方code
     */
    public LoginRequest(String loginCode) {
        this.loginCode = loginCode;
    }

    /**
     * Gets the value of loginCode
     *
     * @return the value of loginCode
     */
    public String getLoginCode() {
        return loginCode;
    }

    /**
     * Sets the loginCode
     * <p>You can use getLoginCode() to get the value of loginCode</p>
     *
     * @param loginCode loginCode
     */
    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }
}
