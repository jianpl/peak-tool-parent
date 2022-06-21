package ink.gfwl.jd.model.order.params;

import java.io.Serializable;

/**
 * 提交订单请求参数
 * @author jianpòlan
 * @version 1.0
 **/
public class OrderSubmitParam extends OrderBaseRequireParam implements Serializable {

    /**
     * 否	邮编，最多20个字符
     */
    private String zip;

    /**
     * 否	座机号，最多20个字符
     */
    private String phone;

    /**
     * 否	备注（少于100字）
     */
    private String remark;

    /**
     * 否	发票抬头  (如果selectedInvoiceTitle=5则此字段必须) 需regCompanyName跟此字段传递一致
     */
    private String companyName;

    /**
     * 否   注意
     * 支付明细，
     * 当paymentType为20时候必须递此字段
     * flag为区分字段
     * 枚举：1 为个人，2为企业
     * paymentType为 支付类型
     * 枚举定义：
     * 17, "微信支付"
     * 101, "金采支付",
     * 4,“预存款”
     * payMoney为支付金额 details
     * 单位：元
     * [
     *     {
     *         "payMoney":20,
     *         "paymentType":"17",
     *         "flag":"1"
     *     },
     *     {
     *         "payMoney":80,
     *         "paymentType":"4",
     *         "flag":"2"
     *     }
     */
    private String payDetails;

    /**
     * 否   增专票收票人姓名
     */
    private String invoiceName;

    /**
     * 否	增专票收票人所在省(京东地址编码)
     * 选填
     */
    private Integer invoiceProvice;

    /**
     * 否	增专票收票人所在市(京东地址编码)
     * 选填。
     */
    private Integer invoiceCity;

    /**
     * 否	增专票收票人所在区/县(京东地址编码)
     * 选填。
     */
    private Integer invoiceCounty;

    /**
     * 否	增专票收票人所在地址当invoiceType =2时，选填。
     */
    private String invoiceAddress;

    /**
     * 否	专票资质注册地址
     * 选填。
     */
    private String regAddr;

    /**
     * 否	专票资质注册电话
     * 选填。
     */
    private String regPhone;

    /**
     * 否	专票资质注册银行
     * 选填。
     */
    private String regBank;

    /**
     * 否	专票资质银行账号
     * 选填。
     */
    private String regBankAccount;

    /**
     * 否	大家电配送日期：默认值为-1，0表示当天，1表示明天，2：表示后天; 如果为-1表示不使用大家电预约日历
     */
    private Integer reservingDate;

    /**
     * 否	大家电安装日期：默认按-1处理，0表示当天，1表示明天，2：表示后天
     */
    private Integer installDate;

    /**
     * 否	是否选择了安装，默认为true，选择了“暂缓安装”，此为必填项，必填值为false。
     */
    private String needInstall;

    /**
     * 否	中小件配送预约日期，格式：yyyy-MM-dd
     */
    private String promiseDate;

    /**
     * 否	中小件配送预约时间段，时间段如： 9:00-15:00
     */
    private String promiseTimeRange;

    /**
     * 否	中小件预约时间段的标记
     */
    private Integer promiseTimeRangeCode;

    /**
     * 否	家电配送预约日期，格式：yyyy-MM-dd
     */
    private String reservedDateStr;

    /**
     * 否	大家电配送预约时间段，如果：9:00-15:00
     */
    private String reservedTimeRange;

    /**
     * 否	循环日历, 客户传入最近一周可配送的时间段,客户入参:{"3": "09:00-10:00,12:00-19:00","4": "09:00-15:00"}
     */
    private String cycleCalendar;

    /**
     * 否	采购单号，长度范围[1-26]
     */
    private String poNo;

    /**
     * 否	节假日不可配送，默认值为false，表示节假日可以配送，为true表示节假日不配送
     */
    private String validHolidayVocation;

    /**
     * 否	第三方平台采购人账号
     */
    private String thrPurchaserAccount;

    /**
     * 否	第三方平台采购人姓名
     */
    private String thrPurchaserName;

    /**
     * 否	第三方采购人电话（手机号，固定电话区号+号码）
     */
    private String thrPurchaserPhone;


    /**
     * Gets the value of zip
     *
     * @return the value of zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip
     * <p>You can use getZip() to get the value of zip</p>
     *
     * @param zip zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone
     * <p>You can use getPhone() to get the value of phone</p>
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the value of remark
     *
     * @return the value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark
     * <p>You can use getRemark() to get the value of remark</p>
     *
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets the value of companyName
     *
     * @return the value of companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the companyName
     * <p>You can use getCompanyName() to get the value of companyName</p>
     *
     * @param companyName companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets the value of payDetails
     *
     * @return the value of payDetails
     */
    public String getPayDetails() {
        return payDetails;
    }

    /**
     * Sets the payDetails
     * <p>You can use getPayDetails() to get the value of payDetails</p>
     *
     * @param payDetails payDetails
     */
    public void setPayDetails(String payDetails) {
        this.payDetails = payDetails;
    }

    /**
     * Gets the value of invoiceName
     *
     * @return the value of invoiceName
     */
    public String getInvoiceName() {
        return invoiceName;
    }

    /**
     * Sets the invoiceName
     * <p>You can use getInvoiceName() to get the value of invoiceName</p>
     *
     * @param invoiceName invoiceName
     */
    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    /**
     * Gets the value of invoiceProvice
     *
     * @return the value of invoiceProvice
     */
    public Integer getInvoiceProvice() {
        return invoiceProvice;
    }

    /**
     * Sets the invoiceProvice
     * <p>You can use getInvoiceProvice() to get the value of invoiceProvice</p>
     *
     * @param invoiceProvice invoiceProvice
     */
    public void setInvoiceProvice(Integer invoiceProvice) {
        this.invoiceProvice = invoiceProvice;
    }

    /**
     * Gets the value of invoiceCity
     *
     * @return the value of invoiceCity
     */
    public Integer getInvoiceCity() {
        return invoiceCity;
    }

    /**
     * Sets the invoiceCity
     * <p>You can use getInvoiceCity() to get the value of invoiceCity</p>
     *
     * @param invoiceCity invoiceCity
     */
    public void setInvoiceCity(Integer invoiceCity) {
        this.invoiceCity = invoiceCity;
    }

    /**
     * Gets the value of invoiceCounty
     *
     * @return the value of invoiceCounty
     */
    public Integer getInvoiceCounty() {
        return invoiceCounty;
    }

    /**
     * Sets the invoiceCounty
     * <p>You can use getInvoiceCounty() to get the value of invoiceCounty</p>
     *
     * @param invoiceCounty invoiceCounty
     */
    public void setInvoiceCounty(Integer invoiceCounty) {
        this.invoiceCounty = invoiceCounty;
    }

    /**
     * Gets the value of invoiceAddress
     *
     * @return the value of invoiceAddress
     */
    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    /**
     * Sets the invoiceAddress
     * <p>You can use getInvoiceAddress() to get the value of invoiceAddress</p>
     *
     * @param invoiceAddress invoiceAddress
     */
    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    /**
     * Gets the value of regAddr
     *
     * @return the value of regAddr
     */
    public String getRegAddr() {
        return regAddr;
    }

    /**
     * Sets the regAddr
     * <p>You can use getRegAddr() to get the value of regAddr</p>
     *
     * @param regAddr regAddr
     */
    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr;
    }

    /**
     * Gets the value of regPhone
     *
     * @return the value of regPhone
     */
    public String getRegPhone() {
        return regPhone;
    }

    /**
     * Sets the regPhone
     * <p>You can use getRegPhone() to get the value of regPhone</p>
     *
     * @param regPhone regPhone
     */
    public void setRegPhone(String regPhone) {
        this.regPhone = regPhone;
    }

    /**
     * Gets the value of regBank
     *
     * @return the value of regBank
     */
    public String getRegBank() {
        return regBank;
    }

    /**
     * Sets the regBank
     * <p>You can use getRegBank() to get the value of regBank</p>
     *
     * @param regBank regBank
     */
    public void setRegBank(String regBank) {
        this.regBank = regBank;
    }

    /**
     * Gets the value of regBankAccount
     *
     * @return the value of regBankAccount
     */
    public String getRegBankAccount() {
        return regBankAccount;
    }

    /**
     * Sets the regBankAccount
     * <p>You can use getRegBankAccount() to get the value of regBankAccount</p>
     *
     * @param regBankAccount regBankAccount
     */
    public void setRegBankAccount(String regBankAccount) {
        this.regBankAccount = regBankAccount;
    }

    /**
     * Gets the value of reservingDate
     *
     * @return the value of reservingDate
     */
    public Integer getReservingDate() {
        return reservingDate;
    }

    /**
     * Sets the reservingDate
     * <p>You can use getReservingDate() to get the value of reservingDate</p>
     *
     * @param reservingDate reservingDate
     */
    public void setReservingDate(Integer reservingDate) {
        this.reservingDate = reservingDate;
    }

    /**
     * Gets the value of installDate
     *
     * @return the value of installDate
     */
    public Integer getInstallDate() {
        return installDate;
    }

    /**
     * Sets the installDate
     * <p>You can use getInstallDate() to get the value of installDate</p>
     *
     * @param installDate installDate
     */
    public void setInstallDate(Integer installDate) {
        this.installDate = installDate;
    }

    /**
     * Gets the value of needInstall
     *
     * @return the value of needInstall
     */
    public String getNeedInstall() {
        return needInstall;
    }

    /**
     * Sets the needInstall
     * <p>You can use getNeedInstall() to get the value of needInstall</p>
     *
     * @param needInstall needInstall
     */
    public void setNeedInstall(String needInstall) {
        this.needInstall = needInstall;
    }

    /**
     * Gets the value of promiseDate
     *
     * @return the value of promiseDate
     */
    public String getPromiseDate() {
        return promiseDate;
    }

    /**
     * Sets the promiseDate
     * <p>You can use getPromiseDate() to get the value of promiseDate</p>
     *
     * @param promiseDate promiseDate
     */
    public void setPromiseDate(String promiseDate) {
        this.promiseDate = promiseDate;
    }

    /**
     * Gets the value of promiseTimeRange
     *
     * @return the value of promiseTimeRange
     */
    public String getPromiseTimeRange() {
        return promiseTimeRange;
    }

    /**
     * Sets the promiseTimeRange
     * <p>You can use getPromiseTimeRange() to get the value of promiseTimeRange</p>
     *
     * @param promiseTimeRange promiseTimeRange
     */
    public void setPromiseTimeRange(String promiseTimeRange) {
        this.promiseTimeRange = promiseTimeRange;
    }

    /**
     * Gets the value of promiseTimeRangeCode
     *
     * @return the value of promiseTimeRangeCode
     */
    public Integer getPromiseTimeRangeCode() {
        return promiseTimeRangeCode;
    }

    /**
     * Sets the promiseTimeRangeCode
     * <p>You can use getPromiseTimeRangeCode() to get the value of promiseTimeRangeCode</p>
     *
     * @param promiseTimeRangeCode promiseTimeRangeCode
     */
    public void setPromiseTimeRangeCode(Integer promiseTimeRangeCode) {
        this.promiseTimeRangeCode = promiseTimeRangeCode;
    }

    /**
     * Gets the value of reservedDateStr
     *
     * @return the value of reservedDateStr
     */
    public String getReservedDateStr() {
        return reservedDateStr;
    }

    /**
     * Sets the reservedDateStr
     * <p>You can use getReservedDateStr() to get the value of reservedDateStr</p>
     *
     * @param reservedDateStr reservedDateStr
     */
    public void setReservedDateStr(String reservedDateStr) {
        this.reservedDateStr = reservedDateStr;
    }

    /**
     * Gets the value of reservedTimeRange
     *
     * @return the value of reservedTimeRange
     */
    public String getReservedTimeRange() {
        return reservedTimeRange;
    }

    /**
     * Sets the reservedTimeRange
     * <p>You can use getReservedTimeRange() to get the value of reservedTimeRange</p>
     *
     * @param reservedTimeRange reservedTimeRange
     */
    public void setReservedTimeRange(String reservedTimeRange) {
        this.reservedTimeRange = reservedTimeRange;
    }

    /**
     * Gets the value of cycleCalendar
     *
     * @return the value of cycleCalendar
     */
    public String getCycleCalendar() {
        return cycleCalendar;
    }

    /**
     * Sets the cycleCalendar
     * <p>You can use getCycleCalendar() to get the value of cycleCalendar</p>
     *
     * @param cycleCalendar cycleCalendar
     */
    public void setCycleCalendar(String cycleCalendar) {
        this.cycleCalendar = cycleCalendar;
    }

    /**
     * Gets the value of poNo
     *
     * @return the value of poNo
     */
    public String getPoNo() {
        return poNo;
    }

    /**
     * Sets the poNo
     * <p>You can use getPoNo() to get the value of poNo</p>
     *
     * @param poNo poNo
     */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
     * Gets the value of validHolidayVocation
     *
     * @return the value of validHolidayVocation
     */
    public String getValidHolidayVocation() {
        return validHolidayVocation;
    }

    /**
     * Sets the validHolidayVocation
     * <p>You can use getValidHolidayVocation() to get the value of validHolidayVocation</p>
     *
     * @param validHolidayVocation validHolidayVocation
     */
    public void setValidHolidayVocation(String validHolidayVocation) {
        this.validHolidayVocation = validHolidayVocation;
    }

    /**
     * Gets the value of thrPurchaserAccount
     *
     * @return the value of thrPurchaserAccount
     */
    public String getThrPurchaserAccount() {
        return thrPurchaserAccount;
    }

    /**
     * Sets the thrPurchaserAccount
     * <p>You can use getThrPurchaserAccount() to get the value of thrPurchaserAccount</p>
     *
     * @param thrPurchaserAccount thrPurchaserAccount
     */
    public void setThrPurchaserAccount(String thrPurchaserAccount) {
        this.thrPurchaserAccount = thrPurchaserAccount;
    }

    /**
     * Gets the value of thrPurchaserName
     *
     * @return the value of thrPurchaserName
     */
    public String getThrPurchaserName() {
        return thrPurchaserName;
    }

    /**
     * Sets the thrPurchaserName
     * <p>You can use getThrPurchaserName() to get the value of thrPurchaserName</p>
     *
     * @param thrPurchaserName thrPurchaserName
     */
    public void setThrPurchaserName(String thrPurchaserName) {
        this.thrPurchaserName = thrPurchaserName;
    }

    /**
     * Gets the value of thrPurchaserPhone
     *
     * @return the value of thrPurchaserPhone
     */
    public String getThrPurchaserPhone() {
        return thrPurchaserPhone;
    }

    /**
     * Sets the thrPurchaserPhone
     * <p>You can use getThrPurchaserPhone() to get the value of thrPurchaserPhone</p>
     *
     * @param thrPurchaserPhone thrPurchaserPhone
     */
    public void setThrPurchaserPhone(String thrPurchaserPhone) {
        this.thrPurchaserPhone = thrPurchaserPhone;
    }
}
