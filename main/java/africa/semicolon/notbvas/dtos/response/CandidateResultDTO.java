package africa.semicolon.notbvas.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateResultDTO {
	private double percentage;
	private int voteCount;
	private boolean isWinner;
	private String candidateName;
	private String candidateParty;
}
