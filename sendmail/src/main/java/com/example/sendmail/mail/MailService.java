package com.example.sendmail.mail;

/**
 * @author tom
 * @version V1.0
 * @date 2020/10/6 11:24
 */
public interface MailService {

    /**
     * 普通文本邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * html格式的邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    void sendAttachmentsMail(String to, String subject, String content,
                             String filePath);

    /**
     * 带静态资源如图片等的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    void sendInlineResourceMail(String to, String subject, String content,
                                String rscPath, String rscId);
}
