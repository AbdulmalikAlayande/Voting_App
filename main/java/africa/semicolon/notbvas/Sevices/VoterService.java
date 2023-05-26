package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.VoterCreationRequest;
import africa.semicolon.notbvas.dtos.request.VotingRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.VoterUpdateRequest;
import africa.semicolon.notbvas.dtos.response.VoterCreationResponse;
import africa.semicolon.notbvas.dtos.response.VotingResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.FailedRegistrationException;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Voter;


import java.util.List;

public interface VoterService {
	VoterCreationResponse registerNewVoter(VoterCreationRequest voterRequest) throws FailedRegistrationException;
	VoterCreationResponse updateVoter(VoterUpdateRequest voterUpdateRequest);
	VotingResponse castVote(VotingRequest votingRequest) throws RequestNotFoundException;
	List<VoterCreationResponse> getAllVoters();
	VoterCreationResponse findById(String id) throws RequestNotFoundException;
	Voter getVoterById(String id) throws RequestNotFoundException;
	List<Voter> getAllVoterObjects();
	
	String deleteById(String id) throws RequestNotFoundException;
	int getCountOfAllVoters();
	
}
