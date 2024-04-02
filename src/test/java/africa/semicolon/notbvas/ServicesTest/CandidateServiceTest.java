package africa.semicolon.notbvas.ServicesTest;

import africa.semicolon.notbvas.Sevices.CandidateService;
import africa.semicolon.notbvas.Sevices.CandidateServiceImplementation;
import africa.semicolon.notbvas.data.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.data.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.exceptions.RequestNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateServiceTest {
	
	CandidateService candidateService;
	CandidateRequest candidateRequest;
	CandidateResponse returnedCandidateResponse;
	
	@BeforeEach void startAllTestWith(){
		candidateService = CandidateServiceImplementation.getInstance();
		candidateRequest = CandidateRequest.builder()
				                   .candidateName("Tinubu ASSiwaju")
				                   .candidatePartyName("APC")
				                   .electionId("12345")
				                   .build();
		returnedCandidateResponse = candidateService.registerNewCandidateCandidate(candidateRequest);
	}
	
	@Test void registerNewCandidateTest(){
		assertNotNull(returnedCandidateResponse.getMessage());
		assertNotNull(returnedCandidateResponse.getCandidateName());
		assertEquals("Successful", returnedCandidateResponse.getMessage());
		assertEquals(BigInteger.ONE.intValue(), candidateService.getAllCandidatesInTheDatabase().size());
	}
	
	@Test void getAllCandidates(){
		List<CandidateResponse> candidateResponses = new ArrayList<>();
		CandidateRequest candidateRequest1 = CandidateRequest.builder()
				                                     .candidatePartyName("Labour Party")
				                                     .candidateName("Obi")
				                                     .build();
		CandidateRequest candidateRequest2 = CandidateRequest.builder()
				                                     .candidatePartyName("PDP the killers")
				                                     .candidateName("Atiku The Thief")
				                                     .build();
		candidateResponses.add(returnedCandidateResponse);
		candidateResponses.add(candidateService.registerNewCandidateCandidate(candidateRequest1));
		candidateResponses.add(candidateService.registerNewCandidateCandidate(candidateRequest2));
		for (int i = 0; i < candidateService.getAllCandidatesInTheDatabase().size(); i++) {
			assertNotNull(candidateService.getAllCandidatesInTheDatabase().get(i));
		}
		assertEquals(candidateResponses, candidateService.getAllCandidatesInTheDatabase());
		assertEquals(BigInteger.valueOf(3).intValue(), candidateService.getAllCandidatesInTheDatabase().size());
	}
	
	@Test void getCandidatesByElectionIdTest(){
		assertNotNull(candidateService.getCandidatesByElectionId(candidateRequest.getElectionId()));
		CandidateRequest candidateRequest1 = CandidateRequest.builder()
				                                     .candidatePartyName("Labour Party")
				                                     .electionId("12345")
				                                     .candidateName("Obi")
				                                     .build();
		CandidateRequest candidateRequest2 = CandidateRequest.builder()
				                                     .candidatePartyName("PDP the killers")
				                                     .candidateName("Atiku The Thief")
				                                     .electionId("12345")
				                                     .build();
		candidateService.registerNewCandidateCandidate(candidateRequest1);
		candidateService.registerNewCandidateCandidate(candidateRequest2);
		for (int i = 0; i < candidateService.getCandidatesByElectionId(candidateRequest.getElectionId()).size(); i++) {
			assertNotNull(candidateService.getCandidatesByElectionId(candidateRequest.getElectionId()).get(i));
		}
	}
	
	@Test void getCandidateByCandidateIdTest(){
		assertNotNull(candidateService.findCandidateBy(candidateService.getAllCandidatesInTheDatabase().get(candidateService
				                                                                                      .getAllCandidatesInTheDatabase().size() - 1).getId()));
	}
	
	@Test void getCandidateByCandidateName(){
		assertNotNull(candidateService.findCandidateByName(returnedCandidateResponse.getCandidateName()));
	}
	
	@Test void deleteCandidateByIdTest() throws RequestNotFoundException {
		assertEquals("Successfully Deleted", candidateService.deleteCandidateBy(candidateService.getAllCandidatesInTheDatabase().get(candidateService
				                                                                                        .getAllCandidatesInTheDatabase().size() - 1).getId()));
		
	}
	@Test void deleteCandidateByCandidateNameTest() throws RequestNotFoundException{
		assertEquals("Successfully Deleted", candidateService.deleteCandidateByCandidateName(returnedCandidateResponse.getCandidateName()));
	}
}
