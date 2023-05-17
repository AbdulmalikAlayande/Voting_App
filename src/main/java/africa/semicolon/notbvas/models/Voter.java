package africa.semicolon.notbvas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Voter {
	private String id;
	private String name;
	private Gender gender;
	private UserInformation userInfo;
	private Address address;
	private Integer age;
	private String voterIdentificationNumber;
	
	public void findCommonPrefix(String[] arrayOfStrings){
		for (int i = 0; i < arrayOfStrings.length; i++) {
			for (int j = 0; j < arrayOfStrings.length; j++) {
//				if (arrayOfStrings[i].charAt(j) == arrayOfStrings[i+1].charAt(i))
			}
		}
	}
}
