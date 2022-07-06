package ink.gfwl.util.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 正则工具
 * @author jianpòlan
 * @version 1.0
 **/
public class RegexUtils implements RegexConstant{


    /**
     * 是否为手机号
     * @param mobile 手机号
     * @return true为正确
     */
    public static boolean isMobile(String mobile){
        return isMatch(Pattern.compile(CHINA_MOBILE), mobile);
    }

    /**
     * 是否为手机号
     * @param idCard15 15位身份证
     * @return true为正确
     */
    public static boolean isIdCard15(String idCard15){
        return isMatch(Pattern.compile(REGEX_ID_CARD15), idCard15);
    }

    /**
     * 是否为身份证
     * @param idCard18 18位身份证
     * @return true为正确
     */
    public static boolean isIdCard18(String idCard18){
        return isMatch(Pattern.compile(REGEX_ID_CARD18), idCard18);
    }

    /**
     * 是否为邮箱
     * @param email email
     * @return true为正确
     */
    public static boolean isEmail(String email){
        return isMatch(Pattern.compile(REGEX_EMAIL), email);
    }

    /**
     * 是否为url
     * @param url url
     * @return true为正确
     */
    public static boolean isUrl(String url){
        return isMatch(Pattern.compile(REGEX_URL), url);
    }

    /**
     * 匹配
     * @param pattern Pattern
     * @param str 匹配内容
     * @return 结果
     */
    public static boolean isMatch(Pattern pattern, String str) {
        return StringUtils.isNotEmpty(str) && pattern.matcher(str).matches();
    }

}
