package africa.semicolon.notbvas.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoterCreationResponse {
	private String name;
	private String email;
	private String voterIdentificationNumber;
	private String message;
	private String id;
}
