package africa.semicolon.notbvas.data.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElectionResponse {
	private LocalDate electionDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String electionType;
	private int numberOfCandidates;
	private String winnerParty;
	private String winnerName;
	private String electionId;
	private boolean ongoing;
}
