package africa.semicolon.notbvas.data.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {
	private String id;
	private String partyName;
	private int numberOfVotes;
	private int percentage;
	private String partyId;
	private String electionId;
	private boolean stoppedVoteCount;
	private String candidateName;
}
