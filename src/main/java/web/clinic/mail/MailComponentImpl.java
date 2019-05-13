package web.clinic.mail;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailComponentImpl implements MailComponent {

	private JavaMailSender javaMailSender;
	
	public MailComponentImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
		
	}
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
	        try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setTo(to);
	            message.setSubject(subject);
	            message.setText(text);
	
	            javaMailSender.send(message);
	        } catch (MailException exception) {
	            exception.printStackTrace();
	        }
	    }
}
