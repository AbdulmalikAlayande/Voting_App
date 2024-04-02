package africa.semicolon.notbvas.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ElectionRequest {
	private LocalTime startTime;
	private LocalTime endTime;
	private int numberOfCandidates;
	private String electionType;
}
