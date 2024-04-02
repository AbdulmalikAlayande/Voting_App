package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.data.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.data.dtos.request.PartyRequest;
import africa.semicolon.notbvas.data.dtos.request.updateRequest.CandidateUpdateRequest;
import africa.semicolon.notbvas.data.dtos.request.updateRequest.PartyUpdateRequest;
import africa.semicolon.notbvas.data.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.data.dtos.response.PartyResponse;
import africa.semicolon.notbvas.exceptions.RequestNotFoundException;

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
