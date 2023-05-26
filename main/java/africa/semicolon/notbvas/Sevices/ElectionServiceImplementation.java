package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.ElectionRequest;
import africa.semicolon.notbvas.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.dtos.response.ElectionResult;

import java.util.List;

public class ElectionServiceImplementation implements ElectionService{
	
	@Override
	public ElectionResponse findById(String id) {
		return null;
	}
	
	@Override
	public List<ElectionResponse> findAll() {
		return null;
	}
	
	@Override
	public ElectionResponse save(ElectionRequest electionRequest) {
		return null;
	}
	
	@Override
	public String deleteById(String id) {
		return null;
	}
	
	@Override
	public int getCountOfAllElections() {
		return 0;
	}
	
	@Override
	public String startElection(String electionId) {
		return null;
	}
	
	@Override
	public String endElection(String electionId) {
		return null;
	}
	
	@Override
	public String notifyAllVotersThatElectionHasStarted() {
		return null;
	}
	
	@Override
	public String notifyAllVotersThatElectionHasEnded() {
		return null;
	}
	
	@Override
	public List<ElectionResponse> getActiveElections(String electionId) {
		return null;
	}
	
	@Override
	public ElectionResult getElectionResults(String electionId) {
		return null;
	}
}
