/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.util;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author tonyliu
 */
public class EmailUtil {
    // username & password: create the account for fun
	final static String from = "tonnyliu1122@gmail.com";
	final static String password = "liutao860716";

	// sending a welcome email to vendor
	public static void sendWelcomeEmail(String emailAddress) {
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.timeout", "25000");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}

				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailAddress));
			//Set to: header field 
			message.setSubject("Welcome to our online-shopping company!");
			
			//This mail has 2 part, the body and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");
			
			//first part: html
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<p>Welcome to our online-shopping Company!</p><img src=\"https://www.wirecard.at/fileadmin/user_upload/wirecard-cee/landingpages/online_shopping_center/online-shopping-center_header.jpg\">";
			messageBodyPart.setContent(htmlText, "text/html");
			
			//add it
			multipart.addBodyPart(messageBodyPart);
			
			//second part (the image)
//			messageBodyPart = new MimeBodyPart();
//			DataSource fds = new FileDataSource(path);
			
			//messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");
			
			//add image to the multipart
			multipart.addBodyPart(messageBodyPart);
			
			//put everything together
			message.setContent(multipart);
			
			//send message
			Transport.send(message);

			System.out.println("Sent the email successfully!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
