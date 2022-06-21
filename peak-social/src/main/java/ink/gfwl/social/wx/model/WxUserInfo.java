package ink.gfwl.social.wx.model;

import java.io.Serializable;
import java.util.List;

/**
 * 微信用户信息
 * @author jianpòlan
 * @version 1.0
 **/
public class WxUserInfo implements Serializable {

    /**
     * 普通用户的标识，对当前开发者帐号唯一
     */
    private String openid;
    /**
     * 普通用户昵称
     */
    private String nickname;
    /**
     * 普通用户性别，1为男性，2为女性
     */
    private Integer sex;
    /**
     * 普通用户个人资料填写的省份
     */
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    private String city;
    /**
     * 国家，如中国为CN
     */
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    private String headimgurl;
    /**
     * 用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     */
    private List<String> privilege;
    /**
     * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     */
    private String unionid;

    /**
     * Gets the value of openid
     *
     * @return the value of openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * Sets the openid
     * <p>You can use getOpenid() to get the value of openid</p>
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * Gets the value of nickname
     *
     * @return the value of nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname
     * <p>You can use getNickname() to get the value of nickname</p>
     *
     * @param nickname nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the value of sex
     *
     * @return the value of sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Sets the sex
     * <p>You can use getSex() to get the value of sex</p>
     *
     * @param sex sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * Gets the value of province
     *
     * @return the value of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province
     * <p>You can use getProvince() to get the value of province</p>
     *
     * @param province province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the value of city
     *
     * @return the value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city
     * <p>You can use getCity() to get the value of city</p>
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the value of country
     *
     * @return the value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country
     * <p>You can use getCountry() to get the value of country</p>
     *
     * @param country country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the value of headimgurl
     *
     * @return the value of headimgurl
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * Sets the headimgurl
     * <p>You can use getHeadimgurl() to get the value of headimgurl</p>
     *
     * @param headimgurl headimgurl
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * Gets the value of privilege
     *
     * @return the value of privilege
     */
    public List<String> getPrivilege() {
        return privilege;
    }

    /**
     * Sets the privilege
     * <p>You can use getPrivilege() to get the value of privilege</p>
     *
     * @param privilege privilege
     */
    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

    /**
     * Gets the value of unionid
     *
     * @return the value of unionid
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * Sets the unionid
     * <p>You can use getUnionid() to get the value of unionid</p>
     *
     * @param unionid unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
