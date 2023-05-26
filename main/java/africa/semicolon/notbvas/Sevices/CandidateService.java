package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.CandidateUpdateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Candidate;

import java.util.List;

public interface CandidateService {
	
	CandidateResponse registerNewCandidateCandidate(CandidateRequest candidate);
	CandidateResponse updateCandidate(CandidateUpdateRequest candidateRequest) throws RequestNotFoundException;
	CandidateResponse updateCandidate(Candidate candidate);
	CandidateResponse findCandidateBy(String candidateId);
	CandidateResponse findCandidateByName(String candidateName);
	List<CandidateResponse> getCandidatesByElectionId(String electionId);
	List<CandidateResponse> getAllCandidatesInTheDatabase();
	String deleteCandidateBy(String candidateId) throws RequestNotFoundException;
	String deleteCandidateByCandidateName(String candidateName) throws RequestNotFoundException;
	
	Candidate getCandidateByPartyName(String vin);
}
