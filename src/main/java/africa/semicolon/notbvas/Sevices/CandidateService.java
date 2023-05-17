package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;

import java.util.List;

public interface CandidateService {
	
	CandidateResponse registerNewCandidateCandidate(CandidateRequest candidate);
	CandidateResponse updateCandidate(CandidateRequest candidateRequest);
	CandidateResponse findCandidateBy(String candidateId);
	CandidateResponse findCandidateByName(String candidateName);
	List<CandidateResponse> getCandidatesByElectionId(String electionId);
	List<CandidateResponse> getAllCandidatesInTheDatabase();
	String deleteCandidateBy(String candidateId);
}
