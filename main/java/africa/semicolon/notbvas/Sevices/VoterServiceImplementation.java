package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.VoterResponse;
import africa.semicolon.notbvas.models.Voter;
import africa.semicolon.notbvas.repositories.VoterRepository;
import africa.semicolon.notbvas.repositories.VoterRepositoryImpl;
import africa.semicolon.notbvas.utils.AppUtils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class VoterServiceImplementation implements VoterService{
	VoterRepository voterRepository = new VoterRepositoryImpl();
	@Override
	public VoterResponse registerNewVoter(VoterRequest voterRequest) {
		return Mapper.map(voterRepository.save(Mapper.map(voterRequest)));
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
}
