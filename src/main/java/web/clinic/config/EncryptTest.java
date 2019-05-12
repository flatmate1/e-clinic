package web.clinic.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptTest {
	static String encoded=new BCryptPasswordEncoder().encode("admin");
	public static void main(String args[]) {
		System.out.println(encoded);
	}
	
	

}
