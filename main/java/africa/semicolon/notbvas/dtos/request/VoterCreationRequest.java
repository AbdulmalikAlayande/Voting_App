package africa.semicolon.notbvas.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoterCreationRequest {
	private String name;
	private String email;
	private String password;
	private String houseNumber;
	private String town;
	private String lga;
	private String street;
	private String state;
	private String gender;
	private int age;
	private String userName;
}
