package africa.semicolon.notbvas.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateRequest {
	private String candidateName;
	private String candidatePartyName;
	private String electionId;
	private String partyId;
}
