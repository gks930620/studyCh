package com.study.qna.web;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    
    
   private int setRandomKey(int size) {
  	 
  	 return 0;
  	 
   }
    
    //인증메일 보내기
    public String sendAuthMail(String email,String url,int port) {
      //인증메일 보내기
      MimeMessage mail = mailSender.createMimeMessage();
      
      int authKey=setRandomKey(6);
      String mailContent ="인증번호 : ";
      try {
          mail.setSubject("회원가입 이메일 인증 ", "utf-8");
          mail.setText(mailContent+123456, "utf-8", "html");
          mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
          mailSender.send(mail);
      } catch (MessagingException e) {
          e.printStackTrace();
      }

      //원래는 인증키를 리턴 해줘야 됩니다
        return "이메일인증 성공";
  }
}