package com.abhinash.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	
	public void sendItenary(String toAddress,String filePath) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper =	new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itenary for your Flight");
			messageHelper.setText("Please Find Your Itenary Attached.");
			messageHelper.addAttachment("Itenary", new File(filePath));
			sender.send(message);
			
			
			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
