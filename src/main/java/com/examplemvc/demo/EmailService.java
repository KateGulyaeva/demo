package com.examplemvc.demo;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;

@Service
public interface EmailService {
    void sendSimpleEmail(String toAddress, String subject, String message);

    void sendMail(AbstractEmailContext email) throws MessagingException;

	void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException;

}
