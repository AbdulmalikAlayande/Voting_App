package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.data.dtos.request.VoterCreationRequest;
import africa.semicolon.notbvas.data.dtos.request.VotingRequest;
import africa.semicolon.notbvas.data.dtos.request.updateRequest.VoterUpdateRequest;
import africa.semicolon.notbvas.data.dtos.response.VoterCreationResponse;
import africa.semicolon.notbvas.data.dtos.response.VotingResponse;
import africa.semicolon.notbvas.exceptions.FailedRegistrationException;
import africa.semicolon.notbvas.exceptions.RequestNotFoundException;
import africa.semicolon.notbvas.data.models.Voter;


import java.util.List;

public interface VoterService {
	VoterCreationResponse registerNewVoter(VoterCreationRequest voterRequest) throws FailedRegistrationException;
	VoterCreationResponse updateVoter(VoterUpdateRequest voterUpdateRequest);
	Voter updateVoter(Voter voterUpdate);
	VotingResponse castVote(VotingRequest votingRequest) throws RequestNotFoundException;
	List<VoterCreationResponse> getAllVoters();
	List<Voter> getAllVotersInTheDatabase();
	VoterCreationResponse findById(String id) throws RequestNotFoundException;
	Voter getVoterById(String id) throws RequestNotFoundException;
	List<Voter> getAllVoterObjects();
	
	String deleteById(String id) throws RequestNotFoundException;
	int getCountOfAllVoters();
	
}
