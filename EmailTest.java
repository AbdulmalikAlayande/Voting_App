package gettingmyhandsdirtywithsendingemailsusingjava;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
public class EmailTest {
    public static void main(String[] args) throws MessagingException, IOException {
//		Properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
//	Authentication
	    Authenticator authenticator = new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication("alaabdulmalik03@gmail.com", "akncjypshgzmqkms");
		    }
	    };
		
//		Email session
	    Session session = Session.getInstance(properties, authenticator);
		
//	Message part
	    Message message = new MimeMessage(session);
		Address address = new InternetAddress("dominicrotimi@gmail.com");
		Address recieverAddress = new InternetAddress("alayandezainab64@gmail.com");
		Address address1 = new InternetAddress("coutinhodacruz10@gmail.com");
		Address[] addresses = new Address[]{recieverAddress, address1};
		message.setFrom(address);
		message.setRecipient(Message.RecipientType.CC,recieverAddress);
		message.setRecipients(Message.RecipientType.CC, addresses);
		message.setSubject("Hello There");
		message.setSentDate(new Date(2023, Calendar.JUNE, 20));
		Multipart multipart = new MimeMultipart();
		
//		For the body of the message
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent("Takes in any object so you can put the election result DTo", "text/html");
		multipart.addBodyPart(bodyPart);

//      Since I want to add an attachment with the message
	    File file = new File("C:\\Users\\USER\\OneDrive\\Documents\\Absolute path is a path that has the root directory e.docx");
	    MimeBodyPart bodyPart1 = new MimeBodyPart();
		bodyPart1.attachFile(file);
		multipart.addBodyPart(bodyPart1);
		
//		Takes in an object of multipart
		message.setContent(multipart);
		Transport.send(message);
	    System.out.println("Message successfully sent");
	}
}
