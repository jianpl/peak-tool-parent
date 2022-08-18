package ink.gfwl.util.lang;

import java.security.SecureRandom;

/**
 * 随机字符串、数字、中文生成
 * @author jianpòlan
 * @version 1.0
 **/
public final class RandomUtils implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private static final SecureRandom rand = new SecureRandom();
    private static final String num_str = "0123456789";
    /**
     * 获取指定位数随机数字
     * @param resLength 随机数长度 可以不传 默认值为6
     * @return  参数说明 返回 resLength 位数随机数字
     */
    public static String getNum(int ...resLength){
        if (resLength.length == 0) {
            resLength = new int[1];
            resLength[0] = 6;
        }
        StringBuilder sb = new StringBuilder();
        while (--resLength[0] >= 0) {
            sb.append(num_str.charAt(rand.nextInt(9)));
        }
        return sb.toString();
    }
    /**
     * 获取指定位数随机英文
     *  @param resLength 随机数长度 可以不传
     *  @return  参数说明 返回 resLength 位数随机数字
     */
    public static String getStr(int ...resLength){
        if (resLength.length == 0) {
            resLength = new int[1];
            resLength[0] = 6;//默认值为6
        }
        char [] keys = "qGweZrDtyuXFIiCSoplkAjOhgVfLHdJsaBPYNzKMxUcTvRbnmWQ".toCharArray();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < resLength[0]; i++){
            sb.append(keys[rand.nextInt(keys.length)]);
        }
        return sb.toString();
    }

    /**
     * 获取指定位数随机中文
     *  @param resLength 随机数长度 可以不传,默认为6
     *  @return  参数说明 返回 resLength 位数随机数字
     */
    public static String getZn_CH(int ...resLength){
        if (resLength.length == 0) {
            resLength = new int[1];
            resLength[0] = 6;
        }
        StringBuilder ret=new StringBuilder();
        for(int i=0;i<resLength[0];i++){
            String str = null;
            int heightPos, lowPos; // 定义高低位
            heightPos = (176 + Math.abs(rand.nextInt(39)));
            lowPos = (161 + Math.abs(rand.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (new Integer(heightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try{
                //转成中文
                str = new String(b, "GBK");
            }catch (java.io.UnsupportedEncodingException ex){
                ex.printStackTrace();
            }
            ret.append(str);
        }
        return ret.toString();
    }

}

