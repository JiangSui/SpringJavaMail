package com.offcn.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class Test {
    public static void main(String[] args) throws MessagingException {

        String from="luoagony@qq.com";
        String to="2826347951@qq.com";

        //邮箱测试
        //加载spring容器
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) app.getBean("javaMailSender");

        // 简单的信息载体
       // SimpleMailMessage
        //发送html 和 附件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");


        helper.setFrom(from);
        helper.setTo("18398775849@139.com");

        //文件
       // helper.addAttachment("图片",);

        // html
        helper.setText("",true);

        helper.addInline("www",new File("E:\\360downloads\\2003488.jpg"));

        javaMailSender.send(mimeMessage);
        System.out.println("发送成功!");
    }
}
