package ink.gfwl.jd.model.address;


import ink.gfwl.jd.base.BaseModel;
import ink.gfwl.jd.model.address.result.AddressCheckResult;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class AddressCheckModel extends BaseModel implements Serializable {

    private AddressCheckResult result;

    public AddressCheckResult getResult() {
        return result;
    }

    public void setResult(AddressCheckResult result) {
        this.result = result;
    }
}
