package ink.gfwl.captcha;


import com.sun.mail.util.MailSSLSocketFactory;
import ink.gfwl.captcha.properties.ExMailProperties;
import ink.gfwl.common.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件发送
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
@Service
public class ExMailUtil {

    @Autowired(required = false)
    private ExMailProperties exMailProperties;

    /**
     * 邮件发送
     * @param sender 发件人,可以设置发件人的别名
     * @param subject 主题
     * @param content 内容
     * @param receiverList 收件人,多人接收，emailTo 逗号分隔
     * @return true 发送成功
     */
    public boolean send(String sender, String subject, String content, String receiverList) {
        try {
            Session session = initProperties();
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(exMailProperties.getFrom(), sender));// 发件人,可以设置发件人的别名
            // 收件人,多人接收，emailTo 逗号分隔
            InternetAddress[] internetAddressTo = InternetAddress.parse(receiverList);
            mimeMessage.setRecipients(Message.RecipientType.TO, internetAddressTo);
            // 主题
            mimeMessage.setSubject(subject);
            // 时间
            mimeMessage.setSentDate(new Date());
            // 容器类 附件
            MimeMultipart mimeMultipart = new MimeMultipart();
            // 可以包装文本,图片,附件
            if (ObjectUtils.isNotNull(content)){
                MimeBodyPart bodyPart = new MimeBodyPart();
                // 设置内容 getEmailHtml是邮箱内容模板
                bodyPart.setContent(content, "text/html; charset=UTF-8");
                mimeMultipart.addBodyPart(bodyPart);
            }
            mimeMessage.setContent(mimeMultipart);
            mimeMessage.saveChanges();
            Transport.send(mimeMessage);
            return true;
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 初始化参数
     * @return session
     */
    public Session initProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", exMailProperties.getProtocol());
        properties.setProperty("mail.smtp.host", exMailProperties.getHost());
        properties.setProperty("mail.smtp.port", exMailProperties.getPort());
        // 使用smtp身份验证
        properties.put("mail.smtp.auth", "true");
        // 开启安全协议,使用SSL,企业邮箱必需
        MailSSLSocketFactory mailSSLSocketFactory = null;
        try {
            mailSSLSocketFactory = new MailSSLSocketFactory();
            mailSSLSocketFactory.setTrustAllHosts(true);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        properties.put("mail.smtp.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.socketFactory.port", exMailProperties.getPort());
        return Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(exMailProperties.getFrom(), exMailProperties.getPassword());
            }
        });
    }
}
