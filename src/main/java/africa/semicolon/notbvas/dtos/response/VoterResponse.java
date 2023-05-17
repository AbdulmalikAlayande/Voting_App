package africa.semicolon.notbvas.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoterResponse {
	private String name;
	private String voterIdentificationNumber;
	private String message;
	private String id;
}
