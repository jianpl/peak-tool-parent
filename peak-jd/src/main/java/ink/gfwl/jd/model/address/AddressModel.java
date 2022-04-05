package ink.gfwl.jd.model.address;


import ink.gfwl.jd.base.BaseModel;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class AddressModel extends BaseModel implements Serializable {

    private Map<String, Integer> result;

    public Map<String, Integer> getResult() {
        return result;
    }

    public void setResult(Map<String, Integer> result) {
        this.result = result;
    }
}
