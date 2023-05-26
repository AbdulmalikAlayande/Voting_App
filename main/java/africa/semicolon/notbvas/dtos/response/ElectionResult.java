package africa.semicolon.notbvas.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElectionResult {
	private String winnerName;
	private String winnerParty;
	private CandidateResultDTO winner;
	private int totalVoteCount;
	CandidateResultDTO[] candidateResults;
}
