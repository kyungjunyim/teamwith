package com.teamwith.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	public static String send(String to, String title, String content) {
		Properties props = System.getProperties();
		 props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.debug", "true");
		// �� ȯ�� ������ "���� ����"�� ����� �� �޽����� �����
		Session session = Session.getInstance(props,
               new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() {
                     return new PasswordAuthentication("fastBooster15@gmail.com","teamwith15!");
                 }
               });
		MimeMessage msg = new MimeMessage(session);
		 
		try {
		    // �߽���, ������, ������, ����, ���� ���� ���� �����Ѵ�
		    msg.setFrom(new InternetAddress("fastBooster15@gmail.com", "Teamwith Service"));
		    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		    msg.setSubject(title);
		    msg.setContent(content, "text/html; charset=utf-8");
		 
		    // ������ �߽��Ѵ�
		    Transport.send(msg);
		} catch (Exception e) {
		    // ������ ó��
			e.printStackTrace();
		}
		return "";
	}
}
