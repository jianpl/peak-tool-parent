package ink.gfwl.jd.common;

/**
 * <p>装吧样式(按需查询，请勿全部一次性查询会影响性能；原始文本和URL的区别在于，
 * 原始文本内容大，查询多时影响响应性能，稳定；URL接口返回内容少，频繁查询影
 * 响较小，但是目前托管在CDN。)</p>
 * <p>注意</p>
 * <p>1.当查询商品详情接口中大字段introduction返回包含div的这情况，老的样式表无法正常显示，这个时候需要调用该接口查询装吧样式表</p>
 * <p>2.introduction中包含{@code <div skudesign="100010">}就查PC端样式</p>
 * <p>3.introduction中包含{@code <div skudesign="100011">}就查APP端样式</p>
 * @author jianpòlan
 * @version 1.0
 **/
public enum ProductStyleExts {

    /**
     * PC端CSS样式原始文本
     */
    pcStyleContent,
    /**
     * APP端CSS样式原始文本
     */
    appStyleContent,
    /**
     * PC端CSS样式URL，默认返回该样式
     */
    pcStyleUrl,
    /**
     * APP端CSS样式URL
     */
    appStyleUrl

}
