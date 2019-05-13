package web.clinic.mail;

public interface MailComponent {
	
	void sendSimpleMessage(String to, String subject, String text);
}
