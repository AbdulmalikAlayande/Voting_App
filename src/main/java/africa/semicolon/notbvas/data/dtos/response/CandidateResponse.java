package africa.semicolon.notbvas.data.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponse {
	private String id;
	private String candidateName;
	private String message;
}
