package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.request.PartyRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.CandidateUpdateRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.PartyUpdateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.dtos.response.PartyResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Party;
import africa.semicolon.notbvas.repositories.PartyRepository;
import africa.semicolon.notbvas.repositories.PartyRepositoryImpl;
import africa.semicolon.notbvas.utils.AppUtils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class PartyServiceImplementation implements PartyService{
	CandidateService candidateService = CandidateServiceImplementation.getInstance();
	private static PartyServiceImplementation instance = null;
	private PartyServiceImplementation(){}
	
	public static PartyServiceImplementation getInstance() {
		if (instance == null)
			return new PartyServiceImplementation();
		return instance;
	}
	
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
	public PartyResponse updateParty(PartyUpdateRequest partyUpdateRequest) {
		Party foundParty = partyRepository.findPartyByPartyName(partyUpdateRequest.getPartyFormerName());
		if (partyUpdateRequest.getPartyName() != null) foundParty.setPartyName(partyUpdateRequest.getPartyName());
		return null;
	}
	
	@Override
	public CandidateResponse createCandidate(CandidateRequest candidateRequest) {
		Party foundParty = partyRepository.findPartyByPartyName(candidateRequest.getCandidatePartyName());
		candidateRequest.setPartyId(foundParty.getId());
		return candidateService.registerNewCandidateCandidate(candidateRequest);
	}
	
	@Override
	public CandidateResponse updateCandidate(CandidateUpdateRequest candidateRequest) throws RequestNotFoundException {
		return candidateService.updateCandidate(candidateRequest);
	}
	
	@Override
	public String deleteById(String id) {
		boolean isDeleted = partyRepository.deleteById(id);
		if (!isDeleted)
			return "Error: not deleted";
		return "Deleted Successfully";
	}
}
