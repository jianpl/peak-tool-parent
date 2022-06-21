package ink.gfwl.util.letsencrypt.base;

import ink.gfwl.util.letsencrypt.properties.LetsProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量配置
 * @author jianpòlan
 * @version 1.0
 **/
public class ConstsProperty {

    @Autowired
    private LetsProperties letsProperties;

    /**
     * 基础接口地址
     */
    public final String HOST = "https://api.osfipin.com/letsencrypt/api";
    /**
     * 证书列表
     */
    protected final String CERT_LIST = HOST + "/order/list";
    /**
     * 证书消息
     */
    protected final String CERT_MESSAGE = HOST + "/account/message";
    /**
     * 申请证书
     */
    protected final String CERT_APPLY = HOST + "/order/apply";
    /**
     * 过期自动申请
     */
    protected final String CERT_REPLAY_APPLY = HOST + "/order/renew";
    /**
     * 证书详情
     */
    protected final String CERT_INFO = HOST + "/api/order/detail";
    /**
     * 自动设置
     */
    protected final String CERT_AUTO_SET = HOST + "/order/auto";
    /**
     * 证书验证
     */
    protected final String CERT_VERIFY = HOST + "/order/verify";
    /**
     * 证书下载
     */
    protected final String CERT_DOWN = HOST + "/order/down";
    /*
     * 证书删除
     */
    protected final String CERT_DELETE = HOST + "/order/delete";

    /**
     * 获取认证请求头
     * @return 请求头
     */
    public Map<String, String> getAuthHeader(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+letsProperties.getToken()+":"+letsProperties.getUser());
        return header;
    }

}
