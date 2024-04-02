package ServicesTest;

import africa.semicolon.notbvas.Sevices.CandidateService;
import africa.semicolon.notbvas.Sevices.CandidateServiceImplementation;
import africa.semicolon.notbvas.Sevices.VoterService;
import africa.semicolon.notbvas.Sevices.VoterServiceImplementation;
import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.request.VoterCreationRequest;
import africa.semicolon.notbvas.dtos.request.VotingRequest;
import africa.semicolon.notbvas.dtos.response.VoterCreationResponse;
import africa.semicolon.notbvas.dtos.response.VotingResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.FailedRegistrationException;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoterServiceTest {
	
	private VoterService voterService;
	private VoterCreationRequest voterRequest;
	VoterCreationResponse voterResponse;
	VotingRequest votingRequest;
	CandidateService candidateService;
	CandidateRequest candidateRequest;
	@BeforeEach
	void setUp(){
		voterService = VoterServiceImplementation.getInstance();
		candidateService = CandidateServiceImplementation.getInstance();
		voterRequest = new VoterCreationRequest();
		votingRequest = VotingRequest.builder().candidateParty("ADC").build();
		candidateRequest = CandidateRequest.builder().candidatePartyName("ADC")
				                   .candidateName("Funso Doherty")
				                   .partyId("1234")
				                   .electionId("45678")
				                   .build();
		voterRequest = VoterCreationRequest.builder()
				               .age(20)
				               .lga("Sabo")
				               .name("Abdulmalik")
				               .houseNumber("43")
				               .state("Ogun")
				               .street("edo inside")
				               .town("Ijako")
				               .password("ayanniyi20")
				               .gender("Male")
				               .userName("abdulmalik@20")
				               .build();
		try{
			voterResponse = voterService.registerNewVoter(voterRequest);
		}catch(FailedRegistrationException exception){
			System.out.println(exception.getMessage());
		}
	}
	
	@Test void registrationTest(){
		assertNotNull(voterResponse);
		assertEquals(BigInteger.valueOf(voterService.getCountOfAllVoters()).intValue(), voterService.getCountOfAllVoters());
		assertEquals(BigInteger.ONE.intValue(), voterService.getCountOfAllVoters());
	}
	
	@Test void castVoteTest() throws RequestNotFoundException {
		candidateService.registerNewCandidateCandidate(candidateRequest);
		VotingResponse response = voterService.castVote(votingRequest);
	}
	@Test void findByIdTest() throws RequestNotFoundException {
		VoterCreationResponse foundresponse = voterService.findById(voterService.getAllVoters().get(voterService.getAllVoters().size() - 1).getId());
		assertNotNull(foundresponse);
		assertNotNull(foundresponse.getId());
	}
	
	@Test void getAllVotersTest() {
		VoterCreationResponse voterResponse1 = null;
		try {
			voterResponse1 =
					voterService.registerNewVoter(VoterCreationRequest.builder()
							                              .userName("Balablu")
							                              .street("Blublu")
							                              .age(86)
							                              .name("Asiwaju Bola Hammed Tinubu")
							                              .houseNumber("45")
							                              .town("Oshogbo")
							                              .password("Steal with pen")
							                              .gender("MALE")
							                              .state("Osun")
							                              .build());
		}catch (FailedRegistrationException exception){
			System.out.println(exception.getMessage());
		}
		List<VoterCreationResponse> voterResponseList = new ArrayList<>();
		voterResponseList.add(voterResponse);
		voterResponseList.add(voterResponse1);
		for (int i = 0; i < voterService.getAllVoters().size(); i++){
			assertNotNull(voterService.getAllVoters().get(i));
		}
		assertEquals(voterResponseList, voterService.getAllVoters());
		assertEquals(BigInteger.TWO.intValue(), voterService.getCountOfAllVoters());
	}
	
	@Test void deleteById() throws RequestNotFoundException {
		String message = voterService.deleteById(voterService.getAllVoters().get(voterService.getCountOfAllVoters()-1).getId());
		assertEquals("Deleted Successfully", message);
		assertEquals(BigInteger.ZERO.intValue(), voterService.getCountOfAllVoters());
	}
}
