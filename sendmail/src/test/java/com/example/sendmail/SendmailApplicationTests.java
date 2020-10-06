package com.example.sendmail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendmailApplicationTests {

    @Autowired
    private com.example.sendmail.mail.MailService mailService;

    String receiveMail = "******@qq.com";

    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail(receiveMail,"这是一封自动发送的邮件","祝你每天开开心心！");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                " <h3>hello baby ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(receiveMail,"这是⼀一封HTML邮件",content);
    }

    @Test
    public void sendAttachmentsMail() {
//        String filePath="F:\\李瑜简历.doc";
        String filePath="F:\\KuGou\\花神泪.mp3";
        mailService.sendAttachmentsMail(receiveMail, "主题：看看我简历哦",
                                "看附件", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "123";
        String content = "<html><body>这是有图⽚片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "G:\\chrome下载\\古装美女.jpg";
        mailService.sendInlineResourceMail(receiveMail, "主题：这是有图⽚片的邮件",
                content, imgPath, rscId);
    }

    @Test
    public void sendInlineResourceMailMusic() {
        String rscId = "123";
        String content =
                "<html><body>" +
                "<embed src=\"F:\\KuGou\\花神泪.mp3\" />"+
//                "<bgsound src=\"F:\\KuGou\\花神泪.mp3\" />"+
                "图⽚：<img src=\'cid:" + rscId + "\' >" +
                "</body></html>";
        String imgPath = "G:\\chrome下载\\古装美女.jpg";
        mailService.sendInlineResourceMail(receiveMail, "主题：图片邮件",
                content, imgPath, rscId);
    }
}
