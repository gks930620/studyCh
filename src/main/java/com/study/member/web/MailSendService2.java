package com.study.member.web;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


public class MailSendService2 {
    @Autowired
    private JavaMailSenderImpl mailSender;

    
   
 

    //인증코드 난수 발생
    private String getAuthCode(int size) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;
        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }
        return buffer.toString();
    }

    //인증메일 보내기
    public String sendAuthMail(String email,String url,int port) {
      //6자리 난수 인증번호 생성
      String authKey = getAuthCode(6);
      //인증메일 보내기
      MimeMessage mail = mailSender.createMimeMessage();
      String mailContent = "인증번호:   "+authKey ;
      try {
          mail.setSubject("회원가입 이메일 인증 ", "utf-8");
          mail.setText(mailContent, "utf-8", "html");
          mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
          mailSender.send(mail);
      } catch (MessagingException e) {
          e.printStackTrace();
      }

        return authKey;
  }
}