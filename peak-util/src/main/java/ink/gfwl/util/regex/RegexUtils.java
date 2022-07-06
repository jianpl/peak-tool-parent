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
     * 匹配
     * @param pattern Pattern
     * @param str 匹配内容
     * @return 结果
     */
    public static boolean isMatch(Pattern pattern, String str) {
        return StringUtils.isNotEmpty(str) && pattern.matcher(str).matches();
    }

}
