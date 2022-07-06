package ink.gfwl.util.security;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

/**
 * DES 加解密工具
 * @author jianpòlan
 * @version 1.0
 * @since 1.0.2
 **/
@NoArgsConstructor
public final class DesUtils {

    /**
     * des 加密
     * @param source 加密内容
     * @param key key
     * @return 加密结果（base64）
     */
    public static String desEncrypt(String source, String key){
        DES des = SecureUtil.des(key.getBytes());
        return des.encryptBase64(source, StandardCharsets.UTF_8).replaceAll("[\\s*\t\n\r]", "");
    }

    /**
     * des 解密
     * @param source 解密内容
     * @param key key
     * @return 解密结果
     */
    public static String desDecrypt(String source, String key){
        DES des = SecureUtil.des(key.getBytes());
        byte[] decrypt = des.decrypt(source);
        return new String(decrypt);
    }

}
