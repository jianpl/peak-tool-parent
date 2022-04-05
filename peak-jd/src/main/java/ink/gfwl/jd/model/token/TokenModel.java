package ink.gfwl.jd.model.token;

import ink.gfwl.jd.base.BaseModel;
import ink.gfwl.jd.model.token.result.TokenResult;

import java.io.Serializable;

/**
 * TOKEN实体
 * @author jianpòlan
 * @version 1.0
 **/
public class TokenModel extends BaseModel implements Serializable {

    private TokenResult result;

    public TokenResult getResult() {
        return result;
    }

    public void setResult(TokenResult result) {
        this.result = result;
    }
}
