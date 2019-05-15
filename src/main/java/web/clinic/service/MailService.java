package web.clinic.service;

import org.springframework.stereotype.Service;

public interface MailService {
	
    void sendSimpleMessage(String to, String subject, String text);
}