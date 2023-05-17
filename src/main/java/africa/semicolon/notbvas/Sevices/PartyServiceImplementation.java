package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.PartyRequest;
import africa.semicolon.notbvas.dtos.response.PartyResponse;
import africa.semicolon.notbvas.repositories.PartyRepository;
import africa.semicolon.notbvas.repositories.PartyRepositoryImpl;
import africa.semicolon.notbvas.utils.AppUtils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class PartyServiceImplementation implements PartyService{
	PartyRepository partyRepository = new PartyRepositoryImpl();
	
	@Override
	public PartyResponse findById(String id) {
		return Mapper.map(partyRepository.findById(id));
	}
	
	@Override
	public List<PartyResponse> findAll() {
		List<PartyResponse> responses = new ArrayList<>();
		for (int i = 0; i < partyRepository.findAll().size(); i++) {
			if (partyRepository.findAll().get(i) != null)
				responses.add(Mapper.map(partyRepository.findAll().get(i)));
		}
		return responses;
	}
	
	@Override
	public PartyResponse registerNewPartyTest(PartyRequest partyRequest) {
		return Mapper.map(partyRepository.save(Mapper.map(partyRequest)));
	}
	
	@Override
	public String deleteById(String id) {
		boolean isDeleted = partyRepository.deleteById(id);
		if (!isDeleted)
			return "Error: not deleted";
		return "Deleted Successfully";
	}
}
