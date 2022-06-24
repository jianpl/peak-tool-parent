package ink.gfwl.social.wx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.lang.ObjectUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.Map;


/**
 * 对微信小程序用户加密数据的解密示例代码
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class WXBizDataCrypt {

    private final String appid;

    private final String sessionKey;

    public WXBizDataCrypt(String appid, String sessionKey) {
        this.appid = appid;
        this.sessionKey = sessionKey;
    }

    /**
     * 检验数据的真实性，并且获取解密后的明文.
     * @param encryptedData string 加密的用户数据
     * @param iv            string 与用户数据一同返回的初始向量
     * @return data string 解密后的原文
     */
    public String decryptData(String encryptedData, String iv) {
        if (ObjectUtils.length(sessionKey) != 24) {
            return "ErrorCode::$IllegalAesKey;";
        }
        // 对称解密秘钥 aeskey = Base64_Decode(session_key), aeskey 是16字节。
        byte[] aesKey = Base64.decodeBase64(sessionKey);

        if (ObjectUtils.length(iv) != 24) {
            return "ErrorCode::$IllegalIv;";
        }
        // 对称解密算法初始向量 为Base64_Decode(iv)，其中iv由数据接口返回。
        byte[] aesIV = Base64.decodeBase64(iv);

        // 对称解密的目标密文为 Base64_Decode(encryptedData)
        byte[] aesCipher = Base64.decodeBase64(encryptedData);

        Map<String, String> map = new HashMap<>();

        try {
            byte[] resultByte = AESUtils.decrypt(aesCipher, aesKey, aesIV);

            if (null != resultByte && resultByte.length > 0) {
                String userInfo = new String(resultByte, StandardCharsets.UTF_8);
                map.put("code", "0000");
                map.put("msg", "succeed");
                map.put("userInfo", userInfo);
                JSONObject jsons = JSON.parseObject(userInfo);
                String id = jsons.getJSONObject("watermark").getString("appid");
                if (!ObjectUtils.equals(id, appid)) {
                    return "ErrorCode::$IllegalBuffer;";
                }
            } else {
                map.put("status", "1000");
                map.put("msg", "false");
            }
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}