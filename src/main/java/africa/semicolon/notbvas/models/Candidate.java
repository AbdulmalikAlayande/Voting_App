package africa.semicolon.notbvas.models;
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
	private String partyId;
	private String electionId;
	private String candidateName;
}
