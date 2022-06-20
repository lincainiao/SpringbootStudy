package com.lin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Controller
public class JavaMailController {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    // 简单邮件发送: SimpleMailMessage
    @RequestMapping("/mail")
    @ResponseBody
    public String mailTest(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置邮件标题
        simpleMailMessage.setSubject("hello, zhizhi.");
        // 邮件正文
        simpleMailMessage.setText("you're so beautiful");
        // 邮件目的地址
        simpleMailMessage.setTo("1054794825@qq.com");
        simpleMailMessage.setFrom("lgl13727753294@163.com");
        javaMailSender.send(simpleMailMessage);
        return "Done!";
    }

    // 复杂邮件:
    @RequestMapping("/mail2")
    @ResponseBody
    public String mailTest2() throws MessagingException {
        // 创建复杂邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
        mimeMessageHelper.setSubject("Hello, Zhizhi");
        // setText: 邮件正文内容，有多种方法重载
        mimeMessageHelper.setText("<h1>Hello Zhizhi</h1>",true);
        // 附件
        File file = new File("B:\\FreeTool\\新建文件夹\\[IM] NO.676","[IM] NO.676 (14).jpg");
        mimeMessageHelper.addAttachment("zsy.jpg",file);
        // 地址
        mimeMessageHelper.setTo("1054794825@qq.com");
        mimeMessageHelper.setFrom("lgl13727753294@163.com");
        javaMailSender.send(mimeMessage);
        return "Done!";
    }
    // 封装发送邮件方法，进行重载
    public void sendMail(String from, String to, String title, String text){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(title);
        mailMessage.setText(text);
        mailMessage.setTo(to);
        mailMessage.setFrom(from);
        javaMailSender.send(mailMessage);
    }
    /**
     *
     * @param from 发送邮件原地址
     * @param to 发送邮件目的地址
     * @param title 发送邮件标题
     * @param text 发送邮件正文
     * @param file 发送的附件
     * @param html 发送的内容是否包含html格式
     * @throws MessagingException
     */
    public void sendMail(String from, String to, String title, String text, File file, boolean html) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(title);
        helper.setText(text,html);
        helper.setTo(to);
        helper.setFrom(from);
        helper.addAttachment(file.getName(),file);
        javaMailSender.send(mimeMessage);
    }
}
