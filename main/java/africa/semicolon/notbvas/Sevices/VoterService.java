package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.VoterResponse;


import java.util.List;

public interface VoterService {
	VoterResponse registerNewVoter(VoterRequest voterRequest);
	
	
	int getCountOfAllVoters();
	
	List<VoterResponse> getAllVoters();
}
