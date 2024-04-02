package africa.semicolon.notbvas.Sevices;
import africa.semicolon.notbvas.models.Voter;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Mailer {
	private Properties getSessionProperties(){
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		return properties;
	}
	
	private Session hostSession(){
		return Session.getInstance(getSessionProperties(), new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("alaabdulmalik03@gmail.com","akncjypshgzmqkms");
			}
		});
	}
	
	private Message composeMessage(){
		Message message = null;
		try {
			message = new MimeMessage(hostSession());
			message.setSubject("Election Updates");
			message.setContent(multipartMessageBody());
		}catch(MessagingException messagingException){
			System.out.println(messagingException.getMessage());
			messagingException.getCause();
			messagingException.printStackTrace();
		}
		return message;
	}
	
	private Multipart multipartMessageBody() {
		Multipart multipart = new MimeMultipart();
		try {
			multipart.addBodyPart(bodyOfMessage());
		} catch (MessagingException exception) {
			System.out.println(exception.getMessage());
			exception.getCause();
			exception.printStackTrace();
		}
		return multipart;
	}
	
	private BodyPart bodyOfMessage() {
		BodyPart messageBody = new MimeBodyPart();
		try {
			messageBody.setContent(htmlBodyContent(), "text/html");
			messageBody.setHeader("Inec update", "Inec gives update on election");
		} catch (MessagingException exception) {
			System.out.println(exception.getMessage());
			exception.getCause();
			exception.printStackTrace();
		}
		return messageBody;
	}
	
	private String htmlBodyContent() {
		return "<html>" +
				       "<head>" +
				       "<title>Election Updates</title>" +
				       "</head>" +
				       "<body>" +
				       "<p>Election Has started</p>" +
				       "<a href='https://github.com/AbdulmalikAlayande'>please click here to cast your vote</a>" +
				       "</body>" +
				       "</html>";
	}
	
	private Address[] addresses(Voter[] voters) {
		Address[] addresses = new Address[voters.length];
		for (int i = 0; i < voters.length; i++) {
			try {
				addresses[i] = new InternetAddress(voters[i].getEmail());
			} catch (AddressException exception) {
				System.out.println(exception.getMessage());
				System.out.println("This is the position of the exception: "+exception.getPos());
				exception.getCause();
				exception.printStackTrace();
			}
		}
		return addresses;
	}
	
	public void send(Voter[] voters) {
		try {
			Transport.send(composeMessage(), addresses(voters));
		} catch (MessagingException exception) {
			System.out.println(exception.getMessage());
			exception.getCause();
			exception.printStackTrace();
		}
		System.out.println("Message Successfully Sent");
	}
	
	public static void main(String[] args) {
		Mailer mailer = new Mailer();
		Voter[] voters = new Voter[2];
		voters[0] = Voter.builder()
				            .email("dominicrotimi@gmail.com")
				            .name("domdom")
				            .build();
		voters[1] = Voter.builder()
				            .email("coutinhodacruz10@gmail.com")
				            .name("dominic")
				            .build();
		mailer.send(voters);
	}
}
