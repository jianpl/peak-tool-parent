package ink.gfwl.social.wx.model;

/**
 * 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为en
 * @author jianpòlan
 * @version 1.0
 **/
public enum LangEnum {

    /**
     * 简体
     */
    ZH_CN("zh_CN"),
    /**
     * 繁体
     */
    ZH_TW("zh_TW"),
    /**
     * 英语
     */
    EN("en");

    private final String value;

    LangEnum(String value){
        this.value = value;
    }

    /**
     * Gets the value of value
     *
     * @return the value of value
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
