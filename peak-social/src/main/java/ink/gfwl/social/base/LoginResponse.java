package ink.gfwl.social.base;


/**
 * 登录返回参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class LoginResponse {

    /**
     * 第三方唯一ID，例: openId（wx）、userId(alipay)、sub(apple)
     */
    private String uniqId;

    /**
     * 平台公共ID(微信登录存在)
     */
    private String unionId;

    /**
     * 解析结果(登录的结果)
     */
    private String result;

    /**
     * 第三方登录TOKEN(如微信会返回access_token)
     */
    private String token;

    public LoginResponse(String uniqId, String unionId, String result) {
        this.uniqId = uniqId;
        this.unionId = unionId;
        this.result = result;
    }

    public LoginResponse(String uniqId, String result) {
        this.uniqId = uniqId;
        this.result = result;
    }

    public LoginResponse() {
    }

    /**
     * Gets the value of uniqId
     *
     * @return the value of uniqId
     */
    public String getUniqId() {
        return uniqId;
    }

    /**
     * Sets the uniqId
     * <p>You can use getUniqId() to get the value of uniqId</p>
     *
     * @param uniqId uniqId
     */
    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    /**
     * Gets the value of unionId
     *
     * @return the value of unionId
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * Sets the unionId
     * <p>You can use getUnionId() to get the value of unionId</p>
     *
     * @param unionId unionId
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * Gets the value of result
     *
     * @return the value of result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the result
     * <p>You can use getResult() to get the value of result</p>
     *
     * @param result result
     */
    public void setResult(String result) {
        this.result = result;
    }


    /**
     * Gets the value of token
     *
     * @return the value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token
     * <p>You can use getToken() to get the value of token</p>
     *
     * @param token token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
