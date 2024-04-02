package africa.semicolon.notbvas.dtos.request.updateRequest;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateUpdateRequest {
	@Nullable private String partyName;
	@Nullable private String electionId;
	@Nullable private String candidateName;
	private String candidateFormerName;
}
