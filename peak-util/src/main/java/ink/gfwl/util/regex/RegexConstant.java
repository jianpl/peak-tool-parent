package ink.gfwl.util.regex;

/**
 * 正则
 * @author jianpòlan
 * @version 1.0
 **/
public interface RegexConstant {

    // 中国手机号
    String CHINA_MOBILE = "^[1][3-9]\\d{9}$";

    // 15位身份证
    String REGEX_ID_CARD15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";

    // 18位身份证
    String REGEX_ID_CARD18 = "^[1-9]\\\\d{5}[1-9]\\\\d{3}((0\\\\d)|(1[0-2]))(([0|1|2]\\\\d)|3[0-1])\\\\d{3}([0-9Xx])$";

    // 邮箱 不支持中文
    String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    // URL
    String REGEX_URL = "[a-zA-z]+://[^\\s]*";

}
