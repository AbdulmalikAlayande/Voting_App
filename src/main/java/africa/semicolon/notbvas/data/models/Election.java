package africa.semicolon.notbvas.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Election {
	private String Id;
	private LocalDate electionDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String electionType;
	private int numberOfCandidates;
	private String winnerParty;
	private String winnerName;
	private boolean ongoing;
}
