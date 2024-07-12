package com.examplemvc.demo;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import java.io.IOException;
import java.util.Properties;


public class EmailClient {
    public static void main(String[] agrs)  throws IOException, MessagingException {
    final Properties properties = new Properties();
    properties.load(EmailClient.class.getClassLoader().getResourceAsStream("mail.properties"));

    Session mailSession = Session.getDefaultInstance(properties);
    MimeMessage message = new MimeMessage(mailSession);
 
        message.setFrom(new InternetAddress("katy.gulyaeva@gmail.com"));
        message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("katy.gulyaeva@gmail.com"));
        message.setSubject("hello world");
        message.setText("There is a sample null");
        /*properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); 
      /**/
      //properties.put("mail.smtp.STARTTLS.enable", "true"); 
    
      // password: "fqbb weuu mxsh seac" LOGIN = "почта"
      //
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       // properties.put("mail.smtp.debug", "true");
        
    
    Transport tr =mailSession.getTransport("smtp");
    tr.connect( "smtp.gmail.com", 465, "", "");
    message.saveChanges();    
    tr.sendMessage(message, message.getAllRecipients());
    tr.close();


   
    
    }
   
}
