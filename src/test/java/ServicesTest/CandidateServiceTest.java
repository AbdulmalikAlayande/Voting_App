package ServicesTest;

import africa.semicolon.notbvas.Sevices.CandidateService;
import africa.semicolon.notbvas.Sevices.CandidateServiceImplementation;
import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CandidateServiceTest {
	
	CandidateService candidateService;
	CandidateRequest candidateRequest;
	CandidateResponse returnedCandidateResponse;
	
	@BeforeEach void startAllTestWith(){
		candidateService = new CandidateServiceImplementation();
		candidateRequest = CandidateRequest.builder()
				                   .candidateName("Tinubu ASSiwaju")
				                   .candidateParty("APC")
				                   .build();
		returnedCandidateResponse = candidateService.registerNewCandidateCandidate(candidateRequest);
	}
	
	@Test void registerNewCandidateTest(){
	
	}
}
