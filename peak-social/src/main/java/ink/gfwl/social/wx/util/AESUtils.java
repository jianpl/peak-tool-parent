package ink.gfwl.social.wx.util;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Security;

/**
 * AESUtils
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 **/
public class AESUtils {
    public static boolean initialized = false;

    /**
     * AES加密
     * @param content 加密内容
     * @param keyByte 加密key
     * @param ivByte 偏移量
     * @return 加密结果
     * @throws InvalidAlgorithmParameterException 异常
     */
    public static byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte)
            throws InvalidAlgorithmParameterException {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            return cipher.doFinal(content);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void initialize() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    /**
     * 生成iv
     * @param iv iv
     * @return {@link AlgorithmParameters}
     * @throws Exception 异常
     */
    private static AlgorithmParameters generateIV(byte[] iv)
            throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }

}
