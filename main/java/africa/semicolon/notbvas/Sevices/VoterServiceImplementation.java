package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.VoterCreationRequest;
import africa.semicolon.notbvas.dtos.request.VotingRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.VoterUpdateRequest;
import africa.semicolon.notbvas.dtos.response.VoterCreationResponse;
import africa.semicolon.notbvas.dtos.response.VotingResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.FailedRegistrationException;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Candidate;
import africa.semicolon.notbvas.models.Gender;
import africa.semicolon.notbvas.models.Voter;
import africa.semicolon.notbvas.repositories.VoterRepository;
import africa.semicolon.notbvas.repositories.VoterRepositoryImpl;
import africa.semicolon.notbvas.utils.AppUtils.VoterMapper;

import java.util.ArrayList;
import java.util.List;

public class VoterServiceImplementation implements VoterService{
	private VoterServiceImplementation(){}
	CandidateService candidateService = CandidateServiceImplementation.getInstance();
	VoterRepository voterRepository = VoterRepositoryImpl.getInstance();
	
	public static VoterService getInstance() {
		return new VoterServiceImplementation();
	}
	private static final List<Voter> voters = new ArrayList<>();
	
	@Override
	public VoterCreationResponse registerNewVoter(VoterCreationRequest voterRequest) throws FailedRegistrationException {
		Voter savedVoter = voterRepository.save(VoterMapper.map(voterRequest));
		voters.addAll(voterRepository.findAll());
		if (savedVoter == null)
			throw new FailedRegistrationException("ERROR: Registration Failed");
		return VoterMapper.map(savedVoter);
	}
	
	@Override
	public VoterCreationResponse updateVoter(VoterUpdateRequest voterUpdateRequest) {
		Voter foundVoter = getUpdatedVoter(voterUpdateRequest);
		return VoterMapper.map(voterRepository.save(foundVoter));
	}
	
	@Override
	public VotingResponse castVote(VotingRequest votingRequest){
		VotingResponse votingResponse = new VotingResponse();
		Candidate candidate = candidateService.getCandidateByPartyName(votingRequest.getCandidateParty());
		Voter foundVoter = voterRepository.getVoterByVoterIdentificationNumber(votingRequest.getVin());
		if (candidate != null && foundVoter != null){
			foundVoter.setTimeOfVote(votingRequest.getTimeVoteWasCasted());
			voterRepository.save(foundVoter);
			candidate.setNumberOfVotes(candidate.getNumberOfVotes() + 1);
			candidateService.updateCandidate(candidate);
			votingResponse.setMessage("Vote casted successfully, May your vote count o!!!");
			return votingResponse;
		}
		else throw new RuntimeException("Failed: either you have entered a wrong Vin or wrong party name");
	}
	
	private Voter getUpdatedVoter(VoterUpdateRequest voterUpdateRequest) {
		Voter foundVoter = voterRepository.findVoterByVoterUsername(voterUpdateRequest.getUserName());
		if (voterUpdateRequest.getName() != null) foundVoter.setName(voterUpdateRequest.getName());
		if (voterUpdateRequest.getPassword() != null) foundVoter.getUserInfo().setPassword(voterUpdateRequest.getPassword());
		if (voterUpdateRequest.getGender() != null) foundVoter.setGender(Gender.valueOf(voterUpdateRequest.getGender().toUpperCase()));
		if (voterUpdateRequest.getAge() != 0) foundVoter.setAge(voterUpdateRequest.getAge());
		if (voterUpdateRequest.getLga() != null) foundVoter.getAddress().setLocalGovernmentArea(voterUpdateRequest.getLga());
		if (voterUpdateRequest.getState() != null) foundVoter.getAddress().setState(voterUpdateRequest.getState());
		if (voterUpdateRequest.getHouseNumber() != null) foundVoter.getAddress().setHouseNumber(voterUpdateRequest.getHouseNumber());
		if (voterUpdateRequest.getStreet() != null) foundVoter.getAddress().setStreet(voterUpdateRequest.getStreet());
		if (voterUpdateRequest.getTown() != null) foundVoter.getAddress().setTown(voterUpdateRequest.getTown());
		if (voterUpdateRequest.getNewUserName() != null) foundVoter.getUserInfo().setUserName(voterUpdateRequest.getUserName());
		return foundVoter;
	}
	
	@Override
	public int getCountOfAllVoters() {
		return voterRepository.getCountOfAllVoters();
	}
	
	@Override
	public List<VoterCreationResponse> getAllVoters() {
		List<VoterCreationResponse> mappedResponses = new ArrayList<>();
		for (Voter voter : voterRepository.findAll()) {
			mappedResponses.add(VoterMapper.map(voter));
		}
		return mappedResponses;
	}
	
	@Override
	public VoterCreationResponse findById(String id) throws RequestNotFoundException {
		Voter voter = voterRepository.findById(id);
		if (voter == null)
			throw new RequestNotFoundException("ERROR: Not Found, probably invalid id");
		return VoterMapper.map(voter);
	}
	
	@Override
	public Voter getVoterById(String id) throws RequestNotFoundException {
		Voter foundVoter = voterRepository.findById(id);
		if (foundVoter != null)
			return foundVoter;
		throw new RequestNotFoundException("Error: Not found");
	}
	
	@Override
	public List<Voter> getAllVoterObjects() {
		return voters;
	}
	
	@Override
	public String deleteById(String id) throws RequestNotFoundException {
		boolean voterIsDeleted = voterRepository.deleteById(id);
		if (!voterIsDeleted)
			throw new RequestNotFoundException("Request not complete, probably incorrect id");
		return "Deleted Successfully";
	}
}
