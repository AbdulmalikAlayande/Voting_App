package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.ElectionRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.ElectionUpdateRequest;
import africa.semicolon.notbvas.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.dtos.response.ElectionResult;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Election;

import java.util.List;
                                                    
public interface ElectionService {
	ElectionResponse findById(String id);
	List<Election> findAll();
	ElectionResponse save(ElectionRequest electionRequest);
	ElectionResponse updateElection(ElectionUpdateRequest electionUpdateRequest);
	Election findElectionById(String electionId) throws RequestNotFoundException;
	String deleteById(String id);
	int getCountOfAllElections();
	String startElection(String electionId) throws RequestNotFoundException;
	String endElection(String electionId) throws RequestNotFoundException;
	String notifyAllVotersThatElectionHasStarted();
	String notifyAllVotersThatElectionHasEnded();
	List<ElectionResponse> getActiveElections(String electionId);
	ElectionResult getElectionResults(String electionId);
//	getElectionStats(String electionId) ;
}
