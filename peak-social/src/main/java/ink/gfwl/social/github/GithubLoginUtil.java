package ink.gfwl.social.github;

import ink.gfwl.common.http.RestTemplateUtil;
import ink.gfwl.common.properties.social.GithubProperties;
import ink.gfwl.social.base.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * github网页授权登录
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class GithubLoginUtil {

    @Autowired(required = false)
    private GithubProperties githubProperties;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 获取github登录地址，页面直接跳转
     * @return 地址
     */
    public String getAuthorizeURL() {
        return "https://github.com/login/oauth/authorize?client_id=" + githubProperties.getClientId() + "&scope=user,public_repo&redirect_uri="+githubProperties.getCallback();
    }

    /**
     * 获取token
     * @param loginRequest 登录参数
     * @return 结果
     */
    public String accessToken(LoginRequest loginRequest) {
        return RestTemplateUtil.get("https://github.com/login/oauth/access_token?client_id=" + githubProperties.getClientId() + "&client_secret=" + githubProperties.getClientSecret() + "&code=" + loginRequest.getLoginCode(), String.class);
    }

    /**
     * 获取用户信息
     * @param accessToken token
     * @return 用户信息
     */
    public String userInfo(String accessToken) {
        return RestTemplateUtil.get("https://api.github.com/user?access_token=" + accessToken + "&scope=public_repo%2Cuser&token_type=bearer", String.class);
    }

}
