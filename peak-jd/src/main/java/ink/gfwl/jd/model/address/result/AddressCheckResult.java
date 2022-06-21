package ink.gfwl.jd.model.address.result;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class AddressCheckResult {

    private boolean success;

    private Integer resultCode;

    private Integer addressId;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
