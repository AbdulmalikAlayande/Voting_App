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
}
