package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;

import java.util.List;

public class CandidateServiceImplementation implements CandidateService{
	@Override
	public CandidateResponse registerNewCandidateCandidate(CandidateRequest candidate) {
		return null;
	}
	
	@Override
	public CandidateResponse updateCandidate(CandidateRequest candidateRequest) {return null;}
	
	@Override
	public CandidateResponse findCandidateBy(String candidateId) {
		return null;
	}
	
	@Override
	public CandidateResponse findCandidateByName(String candidateName) {
		return null;
	}
	
	@Override
	public List<CandidateResponse> getCandidatesByElectionId(String electionId) {
		return null;
	}
	
	@Override
	public List<CandidateResponse> getAllCandidatesInTheDatabase() {
		return null;
	}
	
	@Override
	public String deleteCandidateBy(String candidateId) {
		return null;
	}
}
