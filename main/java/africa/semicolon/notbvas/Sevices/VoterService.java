package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.VoterResponse;

public interface VoterService {
	VoterResponse registerNewVoter(VoterRequest voterRequest);
	
}
