package ink.gfwl.captcha.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 图形验证码
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.captcha.graph",
        ignoreInvalidFields = true
)
public class GraphCaptchaProperties {

    /**
     * 图片宽度
     */
    private Integer width;

    /**
     * 图片高度
     */
    private Integer height;

    /**
     * 默认干扰线数量
     */
    private Integer lines;

    /**
     * 默认字符数量
     */
    private Integer size;

    /**
     * 背景颜色，十六进制
     */
    private String color;

    /**
     * 字体大小
     */
    private Integer fontSize;

    /**
     * 默认字体倾斜
     */
    private Boolean tilt = false;

    /**
     * Gets the value of width
     *
     * @return the value of width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the width
     * <p>You can use getWidth() to get the value of width</p>
     *
     * @param width width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Gets the value of height
     *
     * @return the value of height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the height
     * <p>You can use getHeight() to get the value of height</p>
     *
     * @param height height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Gets the value of lines
     *
     * @return the value of lines
     */
    public Integer getLines() {
        return lines;
    }

    /**
     * Sets the lines
     * <p>You can use getLines() to get the value of lines</p>
     *
     * @param lines lines
     */
    public void setLines(Integer lines) {
        this.lines = lines;
    }

    /**
     * Gets the value of size
     *
     * @return the value of size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets the size
     * <p>You can use getSize() to get the value of size</p>
     *
     * @param size size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Gets the value of color
     *
     * @return the value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color
     * <p>You can use getColor() to get the value of color</p>
     *
     * @param color color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the value of fontSize
     *
     * @return the value of fontSize
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * Sets the fontSize
     * <p>You can use getFontSize() to get the value of fontSize</p>
     *
     * @param fontSize fontSize
     */
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public void setTilt(boolean tilt){
        this.tilt = tilt;
    }

    public Boolean getTilt(){
        return tilt;
    }
}
