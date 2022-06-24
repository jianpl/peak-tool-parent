package ink.gfwl.captcha;

import ink.gfwl.captcha.model.GraphResult;
import ink.gfwl.captcha.properties.GraphCaptchaProperties;
import ink.gfwl.common.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 生成图形验证码
 * @author jianpòlan
 * @version 1.0
 **/
@Service

public class GraphCaptchaUtil {

    @Autowired(required = false)
    private GraphCaptchaProperties captchaProperties;

    // 默认验证码字符集
    private final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 生成图片验证码
     * @return GraphResult
     */
    public GraphResult getGraphImage(){
        StringBuilder sb = new StringBuilder();
        // 创建空白图片
        BufferedImage image = new BufferedImage(captchaProperties.getWidth(), captchaProperties.getHeight(), BufferedImage.TYPE_INT_RGB);
        // 获取图片画笔
        Graphics2D graphic = image.createGraphics();
        // 设置抗锯齿
        graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 设置画笔颜色
        if(ObjectUtils.isNotNull(captchaProperties.getColor())){
            graphic.setBackground(new Color(Integer.parseInt(captchaProperties.getColor(), 16)));
        }else{
            graphic.setBackground(Color.WHITE);
        }
        // 绘制矩形背景
        graphic.fillRect(0, 0, captchaProperties.getWidth(), captchaProperties.getHeight());
        // 画随机字符
        Random ran = new Random();
        int codeWidth = captchaProperties.getWidth() / (captchaProperties.getSize() + 1);
        int y = captchaProperties.getHeight() * 3 / 4;
        for (int i = 0; i < captchaProperties.getSize(); i++) {
            graphic.setColor(getRandomColor());
            Font font = new Font(null, Font.BOLD + Font.ITALIC, captchaProperties.getFontSize());
            if (captchaProperties.getTilt()) {
                int theta = ran.nextInt(45);
                theta = (ran.nextBoolean()) ? theta : -theta;
                AffineTransform affineTransform = new AffineTransform();
                affineTransform.rotate(Math.toRadians(theta), 0, 0);
                font = font.deriveFont(affineTransform);
            }
            graphic.setFont(font);
            int x = (i * codeWidth) + (codeWidth / 2);
            int n = ran.nextInt(chars.length);
            String code = String.valueOf(chars[n]);
            graphic.drawString(code, x, y);
            sb.append(code);
        }
        for (int i = 0; i < captchaProperties.getLines(); i++) {
            graphic.setColor(getRandomColor());
            graphic.drawLine(ran.nextInt(captchaProperties.getWidth()), ran.nextInt(captchaProperties.getHeight()),
                    ran.nextInt(captchaProperties.getWidth()), ran.nextInt(captchaProperties.getHeight()));
        }
        return new GraphResult(image, sb.toString());
    }


    /**
     * 随机取色
     */
    private Color getRandomColor() {
        Random ran = new Random();
        return new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
    }
}
