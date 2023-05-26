package africa.semicolon.notbvas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Voter {
	
	private String id;
	private String name;
	private Gender gender;
	private String email;
	private boolean canNowVote;
	private boolean cannotVoteAgain;
	private LocalTime timeOfVote;
	private UserInformation userInfo;
	private Address address;
	private Integer age;
	private String voterIdentificationNumber;
	
}
