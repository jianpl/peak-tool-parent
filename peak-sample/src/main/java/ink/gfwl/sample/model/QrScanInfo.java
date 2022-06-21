package ink.gfwl.sample.model;

/**
 * 二维码扫描信息
 * @author jianpòlan
 * @version 1.0
 **/
public class QrScanInfo {

    private String scanId;

    private String userId;

    private String ip;

    private String province;

    /**
     * Gets the value of scanId
     *
     * @return the value of scanId
     */
    public String getScanId() {
        return scanId;
    }

    /**
     * Sets the scanId
     * <p>You can use getScanId() to get the value of scanId</p>
     *
     * @param scanId scanId
     */
    public void setScanId(String scanId) {
        this.scanId = scanId;
    }

    /**
     * Gets the value of userId
     *
     * @return the value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     * <p>You can use getUserId() to get the value of userId</p>
     *
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of ip
     *
     * @return the value of ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the ip
     * <p>You can use getIp() to get the value of ip</p>
     *
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
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
}
