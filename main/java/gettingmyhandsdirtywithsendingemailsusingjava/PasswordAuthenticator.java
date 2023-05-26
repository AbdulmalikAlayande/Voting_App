package gettingmyhandsdirtywithsendingemailsusingjava;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class PasswordAuthenticator extends Authenticator {
	
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("alaabdulmalik03@gmail.com", "akncjypshgzmqkms");
	}
}
