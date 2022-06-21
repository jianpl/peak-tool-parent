package ink.gfwl.jd.model.address;


import ink.gfwl.jd.base.BaseModel;
import ink.gfwl.jd.model.address.result.AddressCastResult;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class AddressCastModel extends BaseModel implements Serializable {

    private AddressCastResult result;

    public AddressCastResult getResult() {
        return result;
    }

    public void setResult(AddressCastResult result) {
        this.result = result;
    }
}
