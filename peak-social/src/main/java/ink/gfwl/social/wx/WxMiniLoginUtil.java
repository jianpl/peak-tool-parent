package ink.gfwl.social.wx;

import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 微信小程序登录
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class WxMiniLoginUtil {

    @Resource
    private WxAppLoginUtil wxAppLoginUtil;

    /**
     * 微信小程序登录
     * @param request 登录参数 {@link LoginRequest}
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request) {
        return wxAppLoginUtil.login(request);
    }
}
