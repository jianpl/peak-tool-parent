package ink.gfwl.jd.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ink.gfwl.jd.config.JdConfig;
import ink.gfwl.jd.config.RequestURL;
import ink.gfwl.jd.model.token.TokenModel;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 京东TOKEN
 * @author jianpòlan
 * @version 1.0
 **/
@Component
public class TokenUtils extends RequestURL {

    @Resource
    private JdConfig jdConfig;

    @Resource(name = "peakRedis")
    private RedisTemplate<String, TokenModel> redisTemplate;


    private Map<String, Object> getLoginInfo(){
        Map<String, Object> params = new HashMap<>(6);
        // 固定值 access_token
        String grantType = "access_token";
        params.put("grant_type", grantType);
        params.put("username", jdConfig.getUsername());
        params.put("password", MD5Util.getMD5Str(jdConfig.getPassword()));
        String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String timestamp = new SimpleDateFormat(TIME_FORMAT).format(System.currentTimeMillis());
        params.put("timestamp", timestamp);
        params.put("client_id", jdConfig.getClientId());
        String sign = jdConfig.getClientSecret() + timestamp + jdConfig.getClientId()+ jdConfig.getUsername() + MD5Util.getMD5Str(jdConfig.getPassword()) + grantType + jdConfig.getClientSecret();
        sign = Objects.requireNonNull(MD5Util.getMD5Str(sign)).toUpperCase();
        params.put("sign", sign);
        return params;
    }

    /**
     * 获取token
     * @return TokenModel
     */
    public TokenModel getToken(){
        TokenModel tokenModel = redisTemplate.opsForValue().get(REDIS_TOKEN_KEY);
        if(tokenModel == null){
            String rs = HttpUtil.httpPost(URL_ACCESS_TOKEN, getLoginInfo());
            tokenModel = JSONObject.toJavaObject(JSON.parseObject(rs), TokenModel.class);
            redisTemplate.opsForValue().set(REDIS_TOKEN_KEY, tokenModel, ((TokenModel)tokenModel).getResult().getExpires_in() - 1000, TimeUnit.SECONDS);
        }
        return (TokenModel)tokenModel;
    }

    /**
     * 获取token
     * @return access_token
     */
    public String getTokenStr(){
        return getToken().getResult().getAccess_token();
    }
}
