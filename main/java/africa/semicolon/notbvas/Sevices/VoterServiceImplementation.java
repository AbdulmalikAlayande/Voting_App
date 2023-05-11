package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.VoterResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.FailedRegistrationException;
import africa.semicolon.notbvas.models.Voter;
import africa.semicolon.notbvas.repositories.VoterRepository;
import africa.semicolon.notbvas.repositories.VoterRepositoryImpl;
import africa.semicolon.notbvas.utils.AppUtils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class VoterServiceImplementation implements VoterService{
	VoterRepository voterRepository = new VoterRepositoryImpl();
	@Override
	public VoterResponse registerNewVoter(VoterRequest voterRequest) throws FailedRegistrationException {
		Voter savedVoter = voterRepository.save(Mapper.map(voterRequest));
		if (savedVoter == null)
			throw new FailedRegistrationException("ERROR: Registration Failed");
		return Mapper.map(savedVoter);
	}
	
	@Override
	public int getCountOfAllVoters() {
		return voterRepository.getCountOfAllVoters();
	}
	
	@Override
	public List<VoterResponse> getAllVoters() {
		List<VoterResponse> mappedResponses = new ArrayList<>();
		for (Voter voter : voterRepository.findAll()) {
			mappedResponses.add(Mapper.map(voter));
		}
		return mappedResponses;
	}
	
	@Override
	public VoterResponse findById(String id) {
		
		return null;
	}
	
	@Override
	public String deleteById(String id) {
		return null;
	}
}
