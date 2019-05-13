package web.clinic.service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
	
    void sendSimpleMessage(String to, String subject, String text);
}