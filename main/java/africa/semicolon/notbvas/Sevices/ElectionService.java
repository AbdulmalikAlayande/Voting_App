package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.ElectionRequest;
import africa.semicolon.notbvas.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.dtos.response.ElectionResult;

import java.util.List;
                                                    
public interface ElectionService {
	ElectionResponse findById(String id);
	List<ElectionResponse> findAll();
	ElectionResponse save(ElectionRequest electionRequest);
	String deleteById(String id);
	int getCountOfAllElections();
	String startElection(String electionId);
	String endElection(String electionId);
	String notifyAllVotersThatElectionHasStarted();
	String notifyAllVotersThatElectionHasEnded();
	List<ElectionResponse> getActiveElections(String electionId);
	ElectionResult getElectionResults(String electionId);
//	getElectionStats(String electionId) ;
}
