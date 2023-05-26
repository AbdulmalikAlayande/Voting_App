package africa.semicolon.notbvas.utils.AppUtils;

import java.util.List;
import java.util.regex.Pattern;

public class MyClass{
	public static void main(String[] args) {
		MyClass implementation = new MyClass();
		System.out.printf("%s%n%s%n", "Wait o","am a boy");
		char[] charArray = new char[]{'A','D','E','W','A','L','E'};
		String myString1 = "Hello There";
		String myString = new String(charArray, 1, 4);
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(myString);
		
		String cohortName = "eliTes";
		System.out.println(cohortName.matches("[a-z]+[A-Z]"));
		
		String string = "Abdulma3lik";
		System.out.println(string.matches("[A-Za-z]+"));
		try {
			System.out.println(implementation.emailIsValid("alaabdulmalik03@yahoo.com"));
		}   catch (RuntimeException exception){
			System.out.println(exception.getMessage());
			System.out.println(exception.getClass());
		}
		
		String number = "07036174617";
		String password = "ayanniyi@20";
		System.out.println(number.matches("[0-9]{11}"));
		System.out.println(number.substring(0, 3));
		System.out.println(implementation.validatePhoneNumber(number));
		System.out.println("The password is: "+implementation.passwordIsValid(password));
	}
	
	private boolean passwordIsValid(String password) {
		boolean isValid = false;
		if (password.matches("[A-Za-z]+[0-9]+[!-/][@,%&^$#!()]{8,}")){
			if (password.length() >= 8) {
				isValid = true;
			}
		}
		if (!isValid)return false;
		return isValid;
	}
	public boolean validatePhoneNumber(String phoneNumber){
		String[] allowedDomain = new String[]{"070", "080", "081", "090", "091"};
		if (!phoneNumber.matches("[0-9]{11}") )
			throw new IllegalArgumentException("Invalid phoneNumber");
		for (String s : allowedDomain) {
			if (phoneNumber.substring(0, 3).equals(s))
				return true;
			}
		return false;
	}
	
	public boolean emailIsValid(String email) {
		Pattern regexFormat = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		List<String> allowedDomains = List.of(new String[]{"gmail.com", "yahoo.com", "outlook.com"});
		if (!regexFormat.matcher(email).matches()) throw new IllegalArgumentException("This is not a valid email address");
		String[] emailSplit = email.split("@");
		String domains = emailSplit[1].toLowerCase();
		boolean domainIsValid = false;
		
		for (String allowedDomain: allowedDomains) {
			if (domains.contains(allowedDomain)) {
				domainIsValid = true;
				break;
			}
		}
		if (!domainIsValid) throw new IllegalArgumentException("This is not a valid email address");
		return true;
	}
}
