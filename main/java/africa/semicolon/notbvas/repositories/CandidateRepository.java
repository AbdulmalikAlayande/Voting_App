package africa.semicolon.notbvas.repositories;
import africa.semicolon.notbvas.models.Candidate;
import java.util.List;

public interface CandidateRepository {
	
	Candidate saveCandidate(Candidate candidate);
	Candidate findCandidateBy(String candidateId);
	Candidate findCandidateByName(String candidateName);
	List<Candidate> getCandidatesByElectionId(String electionId);
	List<Candidate> getAllCandidatesInTheDatabase();
	boolean deleteCandidateBy(String candidateId);
	
	boolean deleteCandidateByCandidateName(String candidateName);
	
	Candidate getCandidateByPartyName(String partyName);
}
