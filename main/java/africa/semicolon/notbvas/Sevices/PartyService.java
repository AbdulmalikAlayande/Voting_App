package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.request.PartyRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.CandidateUpdateRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.PartyUpdateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.dtos.response.PartyResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;

import java.util.List;

public interface PartyService {
	PartyResponse findById(String id);
	List<PartyResponse> findAll();
	PartyResponse registerNewPartyTest(PartyRequest partyRequest);
	PartyResponse updateParty(PartyUpdateRequest partyUpdateRequest);
	CandidateResponse createCandidate(CandidateRequest candidateRequest);
	CandidateResponse updateCandidate(CandidateUpdateRequest candidateRequest) throws RequestNotFoundException;
	String deleteById(String id);
}
