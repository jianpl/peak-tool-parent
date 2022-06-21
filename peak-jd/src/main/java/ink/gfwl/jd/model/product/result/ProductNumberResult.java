package ink.gfwl.jd.model.product.result;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductNumberResult implements Serializable {

    private static final long serialVersionUID = 724856652983097652L;

    private String name;

    private Integer page_num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage_num() {
        return page_num;
    }

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }
}
