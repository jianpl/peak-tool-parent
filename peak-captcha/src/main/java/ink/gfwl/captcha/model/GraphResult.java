package ink.gfwl.captcha.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * 图形验证码
 * @author jianpòlan
 * @version 1.0
 **/
public class GraphResult implements Serializable {

    private static final long serialVersionUID = 1967863286853619443L;
    /**
     * 验证码图片
     */
    private BufferedImage image;

    /**
     * 验证码
     */
    private String code;

    public GraphResult() {
    }

    public GraphResult(BufferedImage image, String code) {
        this.image = image;
        this.code = code;
    }

    /**
     * Gets the value of image
     *
     * @return the value of image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Sets the image
     * <p>You can use getImage() to get the value of image</p>
     *
     * @param image image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Gets the value of code
     *
     * @return the value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code
     * <p>You can use getCode() to get the value of code</p>
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
