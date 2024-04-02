package africa.semicolon.notbvas.utils.AppUtils;

import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.CandidateUpdateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Candidate;

public class CandidateMapper{
	
	public static Candidate map(CandidateRequest candidateRequest){
		return Candidate.builder()
				       .candidateName(candidateRequest.getCandidateName())
				       .partyName(candidateRequest.getCandidatePartyName())
				       .electionId(candidateRequest.getElectionId())
				       .partyId(candidateRequest.getPartyId())
				       .build();
	}
	
	public static CandidateResponse map(Candidate candidate){
		return CandidateResponse.builder()
				       .message("Successful")
				       .id(candidate.getId())
				       .candidateName(candidate.getCandidateName())
				       .build();
	}
	
	public static Candidate map(CandidateUpdateRequest candidateUpdateRequest) throws RequestNotFoundException {
		if (candidateUpdateRequest.getCandidateName() == null && candidateUpdateRequest.getPartyName() == null && candidateUpdateRequest.getElectionId() == null)
			throw new RequestNotFoundException("ERROR: You didn't input any value");
		else if (candidateUpdateRequest.getCandidateName() != null && candidateUpdateRequest.getPartyName() == null && candidateUpdateRequest.getElectionId() == null)
		  	return Candidate.builder().candidateName(candidateUpdateRequest.getCandidateName()).build();
		else if (candidateUpdateRequest.getCandidateName() != null && candidateUpdateRequest.getPartyName() != null && candidateUpdateRequest.getElectionId() == null)
			return Candidate.builder().candidateName(candidateUpdateRequest.getCandidateName()).partyName(candidateUpdateRequest.getPartyName()).build();
		else if (candidateUpdateRequest.getCandidateName() != null && candidateUpdateRequest.getPartyName() != null && candidateUpdateRequest.getElectionId() != null)
			return Candidate.builder().candidateName(candidateUpdateRequest.getCandidateName()).partyName(candidateUpdateRequest.getPartyName()).electionId(candidateUpdateRequest.getElectionId()).build();
		else if (candidateUpdateRequest.getCandidateName() != null && candidateUpdateRequest.getPartyName() == null && candidateUpdateRequest.getElectionId() != null)
			return Candidate.builder().candidateName(candidateUpdateRequest.getCandidateName()).electionId(candidateUpdateRequest.getElectionId()).build();
		else if (candidateUpdateRequest.getCandidateName() == null && candidateUpdateRequest.getPartyName() != null && candidateUpdateRequest.getElectionId() != null)
			return Candidate.builder().partyName(candidateUpdateRequest.getPartyName()).electionId(candidateUpdateRequest.getElectionId()).build();
		else if (candidateUpdateRequest.getCandidateName() == null && candidateUpdateRequest.getPartyName() != null && candidateUpdateRequest.getElectionId() == null)
			return Candidate.builder().partyName(candidateUpdateRequest.getPartyName()).build();
		else return null;
	}
}
