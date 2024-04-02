package africa.semicolon.notbvas.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotingRequest {
	private String candidateParty;
	private final LocalTime timeVoteWasCasted = LocalTime.now();
	private String vin;
}
