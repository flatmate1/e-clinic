package web.clinic.service;

import org.springframework.stereotype.Service;

import web.clinic.mail.MailComponent;

@Service
public class MailServiceImpl implements MailService {
	
	private MailComponent mailComponent;
 
	public MailServiceImpl(MailComponent mailComponent) {
		this.mailComponent = mailComponent;
	}

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		mailComponent.sendSimpleMessage(to, subject, text);
	}

}
