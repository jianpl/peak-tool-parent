package ink.gfwl.jd.model.token.result;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class TokenResult implements Serializable {

    private String uid;

    private String refresh_token_expires;

    private Long time;

    private Integer expires_in;

    private String refresh_token;

    private String access_token;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRefresh_token_expires() {
        return refresh_token_expires;
    }

    public void setRefresh_token_expires(String refresh_token_expires) {
        this.refresh_token_expires = refresh_token_expires;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
