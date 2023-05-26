package gettingmyhandsdirtywithsendingemailsusingjava;

import africa.semicolon.notbvas.models.Voter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class UsingJavaMailApi {
	
	public Properties getPropertiesForMySessionAsAHost() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		return properties;
	}
	
	public Session createdSessionForMeAsTheHost(){
		return Session.getDefaultInstance(getPropertiesForMySessionAsAHost(), new PasswordAuthenticator());
	}
	
	public Message composeMessage() {
		Message message = null;
		try {
			message = new MimeMessage(createdSessionForMeAsTheHost());
			message.setSubject("Another Email Message");
			message.setContent(multipartOfMessageIncludingAttachmentAndBodyParts());
			
		} catch (MessagingException exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
		return message;
	}
	
	public Multipart multipartOfMessageIncludingAttachmentAndBodyParts() throws MessagingException {
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(getBodyPart());
		multipart.addBodyPart(getFilePartOfMessageBody());
		return multipart;
	}
	
	private Address[] addressesOfUsers() {
		Address address = null;
		Address address1 = null;
		Address address2 = null;
		try {
			address = new InternetAddress("dominicrotimi@gmail.com");
			address1 = new InternetAddress("alayandesophia2019@gmail.com");
			address2 = new InternetAddress("coutinhodacruz10@gmail.com");
		} catch (AddressException addressException) {
			System.out.println(addressException.getMessage());
			addressException.printStackTrace();
		}
		return new Address[]{address, address1, address2};
	}
	
	private BodyPart getFilePartOfMessageBody() {
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		try {
			File file = new File("C:\\Users\\USER\\Downloads\\Jim Carrey tries to 'calm down' after presenter's jokes.mp4");
			mimeBodyPart.attachFile(file);
		}catch (IOException | MessagingException | NullPointerException filePartOfMessageBody){
			System.out.println(filePartOfMessageBody.getMessage());
			filePartOfMessageBody.printStackTrace();
		}
		return mimeBodyPart;
	}
	
	private BodyPart getBodyPart() {
		BodyPart bodyPart = new MimeBodyPart();
		try {
			bodyPart.setContent(new ObjectMapper().writeValueAsString(new Voter()), "text/html");
			bodyPart.setHeader("My header", "Our header has a lot of heads");
		}catch (MessagingException exception){
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return bodyPart;
	}
	
	public void sendMessage(){
		try {
			Transport.send(composeMessage(), addressesOfUsers());
			System.out.println("Message Successfully Sent");
		}catch (MessagingException exception){
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UsingJavaMailApi mailApi = new UsingJavaMailApi();
		mailApi.sendMessage();
	}
}
