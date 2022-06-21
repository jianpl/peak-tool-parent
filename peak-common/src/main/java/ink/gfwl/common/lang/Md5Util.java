package ink.gfwl.common.lang;

import java.security.MessageDigest;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class Md5Util {

    private static final char[] hexDigest = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public static String md5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            md.update(bytes);
            byte[] newBytes = md.digest();
            char[] result = new char[newBytes.length * 2];
            int k = 0;
            for (byte c : newBytes) {
                result[k++] = hexDigest[c >>> 4 & 0xf];//高四位
                result[k++] = hexDigest[c & 0xf]; //低四位
            }
            return new String(result);
        }catch (Exception e){
            return null;
        }
    }

}
