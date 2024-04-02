package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.ElectionRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.ElectionUpdateRequest;
import africa.semicolon.notbvas.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.dtos.response.ElectionResult;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Election;
import africa.semicolon.notbvas.models.Voter;
import africa.semicolon.notbvas.repositories.ElectionRepository;
import africa.semicolon.notbvas.repositories.ElectionRepositoryImplementation;
import africa.semicolon.notbvas.utils.AppUtils.ElectionMapper;

import java.util.ArrayList;
import java.util.List;

public class ElectionServiceImplementation implements ElectionService{
	private final ElectionRepository electionRepository = new ElectionRepositoryImplementation();
	private final VoterService voterService = VoterServiceImplementation.getInstance();
	private final CandidateService candidateService = CandidateServiceImplementation.getInstance();
	private final MailMessageService messageService = MailMessageImplementation.getInstance();
	@Override
	public ElectionResponse findById(String id) {
		Election foundElection = electionRepository.findById(id);
		if (foundElection != null)
			return ElectionMapper.map(foundElection);
		return null;
	}
	
	@Override
	public List<Election> findAll() {
		List<Election> responses = new ArrayList<>();
		for (Election election : electionRepository.findAll())
			if (election != null) responses.add(election);
		return responses;
	}
	
	@Override
	public ElectionResponse save(ElectionRequest electionRequest) {
		return ElectionMapper.map(electionRepository.save(ElectionMapper.map(electionRequest)));
	}
	
	@Override
	public ElectionResponse updateElection(ElectionUpdateRequest electionUpdateRequest) {
		return null;
	}
	
	@Override
	public Election findElectionById(String electionId) throws RequestNotFoundException {
		Election foundElection = electionRepository.findById(electionId);
		if (foundElection != null) return foundElection;
		throw new RequestNotFoundException("ERROR: not found");
	}
	
	@Override
	public String deleteById(String id) {
		boolean isDeleted = electionRepository.deleteById(id);
		if (!isDeleted)
			throw new IllegalArgumentException("ERROR: incorrect id");
		return "Successfully Deleted";
	}
	
	@Override
	public int getCountOfAllElections() {
		return electionRepository.getCountOfAllElections();
	}
	
	@Override
	public String startElection(String electionId) throws RequestNotFoundException {
		notifyAllVotersThatElectionHasStarted();
		Election foundElection = findElectionById(electionId);
		if (foundElection != null) {
			foundElection.setOngoing(true);
			electionRepository.save(foundElection);
			if (foundElection.isOngoing()) {
				for (int i = 0; i < voterService.getAllVotersInTheDatabase().size(); i++) {
					Voter foundVoter = voterService.getVoterById(voterService.getAllVotersInTheDatabase().get(i).getId());
					foundVoter.setCanNowVote(true);
					voterService.updateVoter(foundVoter);
				}
			}
		}
		return "Election Started Successfully";
	}
	
	private Voter[] arrayOfVoters() {
		return voterService.getAllVoterObjects().toArray(new Voter[voterService.getCountOfAllVoters()]);
	}
	
	@Override
	public String endElection(String electionId) throws RequestNotFoundException {
		Election foundElection = findElectionById(electionId);
		for (int i = 0; i < candidateService.getTheParticularCandidatesByElectionId(electionId).size(); i++) {
			candidateService.getTheParticularCandidatesByElectionId(electionId).get(i).setStoppedVoteCount(true);
		}
		if (foundElection != null && foundElection.isOngoing()) foundElection.setOngoing(false);
		return "Election Has Stopped";
	}
	
	@Override
	public String notifyAllVotersThatElectionHasStarted() {
		messageService.notifyUsersThatElectionHasStarted(arrayOfVoters());
		return "Voters Notified";
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
