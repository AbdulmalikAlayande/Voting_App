package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.PartyRequest;
import africa.semicolon.notbvas.dtos.response.PartyResponse;

import java.util.List;

public interface PartyService {
	PartyResponse findById(String id);
	List<PartyResponse> findAll();
	PartyResponse registerNewPartyTest(PartyRequest partyRequest);
	String deleteById(String id);
}
