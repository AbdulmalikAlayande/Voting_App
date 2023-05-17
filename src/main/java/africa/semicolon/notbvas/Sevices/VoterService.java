package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.VoterResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.FailedRegistrationException;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Voter;


import java.util.List;

public interface VoterService {
	VoterResponse registerNewVoter(VoterRequest voterRequest) throws FailedRegistrationException;
	List<VoterResponse> getAllVoters();
	VoterResponse findById(String id) throws RequestNotFoundException;
	String deleteById(String id) throws RequestNotFoundException;
	int getCountOfAllVoters();
	
}
