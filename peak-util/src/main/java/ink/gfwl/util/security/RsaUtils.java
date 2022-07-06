package ink.gfwl.util.security;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * RSA 加解密工具
 * @author jianpòlan
 * @version 1.0
 * @since 1.0.2
 **/
public final class RsaUtils {

    public static final String ENCRYPT_TYPE = "RSA";

    /**
     * RSA 加密(公钥)
     * @param source 加密内容
     * @param publicKey 加密公钥
     * @return 加密结果
     */
    public static String encrypt(String source ,String publicKey){
        return new RSA(null, publicKey).encryptBase64(source.getBytes(StandardCharsets.UTF_8), KeyType.PublicKey);
    }

    /**
     * RSA 解密(私钥)
     * @param source 解密内容
     * @param privateKey 解密私钥
     * @return 解密结果
     */
    public static String decrypt(String source, String privateKey){
        RSA rsa = new RSA(privateKey, null);
        return new String(rsa.decrypt(source, KeyType.PrivateKey), StandardCharsets.UTF_8);
    }

    /**
     * 获取随机公钥私钥
     * @return Key
     */
    public static Key getRandomKey(){
        KeyPair pair= SecureUtil.generateKeyPair(ENCRYPT_TYPE);
        PrivateKey privateKey=pair.getPrivate();
        PublicKey publicKey=pair.getPublic();
        return new Key(Base64.encode(publicKey.getEncoded()), Base64.encode(privateKey.getEncoded()));
    }

    /**
     * 公钥私钥
     */
    public static class Key implements Serializable {
        private static final long serialVersionUID = -1521062930537294410L;
        private String publicKey;
        private String privateKey;

        public Key(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        /**
         * Gets the value of publicKey
         * @return the value of publicKey
         */
        public String getPublicKey() {
            return publicKey;
        }

        /**
         * Sets the publicKey
         * <p>You can use getPublicKey() to get the value of publicKey</p>
         * @param publicKey publicKey
         */
        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        /**
         * Gets the value of privateKey
         * @return the value of privateKey
         */
        public String getPrivateKey() {
            return privateKey;
        }

        /**
         * Sets the privateKey
         * <p>You can use getPrivateKey() to get the value of privateKey</p>
         * @param privateKey privateKey
         */
        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }
    }

}

