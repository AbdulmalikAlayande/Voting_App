package ServicesTest;

import africa.semicolon.notbvas.Sevices.*;
import africa.semicolon.notbvas.dtos.request.*;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.dtos.response.PartyResponse;
import africa.semicolon.notbvas.dtos.response.VoterCreationResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.FailedRegistrationException;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Candidate;
import africa.semicolon.notbvas.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ElectionServiceTest {
	ElectionService electionService;
	ElectionRequest electionRequest;
	ElectionResponse response;
	VoterService voterService;
	CandidateService candidateService;
	@BeforeEach void startAllTestWith(){
		electionService = new ElectionServiceImplementation();
		voterService = VoterServiceImplementation.getInstance();
		electionRequest = ElectionRequest.builder()
				                  .electionType("Presidential")
				                  .endTime(LocalTime.of(18, 0, 0))
				                  .numberOfCandidates(5)
				                  .startTime(LocalTime.of(9, 0, 0))
				                  .build();
		response = electionService.save(electionRequest);
		candidateService = CandidateServiceImplementation.getInstance();
	}
	
	@Test void findByIdTest(){
		assertNotNull(electionService.findById(electionService.findAll().get(0).getId()));
	}
	
	@Test void saveNewElectionTest(){
		assertNotNull(response);
		assertEquals(BigInteger.ONE.intValue(), electionService.findAll().size());
	}
	
	@Test void findAllTest(){
		assertNotNull(electionService.findAll());
		for (int i = 0; i < electionService.findAll().size(); i++) {
			assertNotNull(electionService.findAll().get(i));
		}
	}
	
	@Test void deleteElectionByIdTest(){
		assertEquals("Successfully Deleted", electionService.deleteById(electionService.findAll().get(0).getId()));
		assertEquals(BigInteger.ZERO.intValue(), electionService.findAll().size());
	}
	
	@Test void testThatAllRequirementsAreFulfilledBeforeElectionStarts() throws RequestNotFoundException {
		// Have An election
		// Have a candidate
		// Have Voters
		// validate that each voter is eleigible to vote
		buildCandidate();
		buildCandidate1();
		buildParty();
		buildParty1();
		buildVoter();
		buildVoter1();
		ElectionResponse response1 = electionService.findById(response.getElectionId());
		assertNotNull(response1);
		for (int i = 0; i < voterService.getAllVotersInTheDatabase().size(); i++) {
			Voter foundVoter = voterService.getVoterById(voterService.getAllVotersInTheDatabase().get(i).getId());
			foundVoter.setCanNowVote(true);
			voterService.updateVoter(foundVoter);
			assertTrue(foundVoter.isCanNowVote());
		}
	}
	
	@Test void testThatAfterElectionStartsAllVotersCanVote(){
		buildVoter();
		buildVoter1();
		buildParty();
		buildParty1();
		buildCandidate();
		buildCandidate1();
		ElectionResponse response1 = electionService.findById(response.getElectionId());
		
		assertNotNull(response1);
		try {
			electionService.startElection(response.getElectionId());
			voterService.castVote(votingRequest());
			voterService.castVote(votingRequest1());
		} catch (RequestNotFoundException e) {
			throw new RuntimeException(e);
		}
		List<Candidate> candidates = candidateService.getAllCandidatesByElectionId(response.getElectionId());
		for (Candidate candidate : candidates) {
			assertEquals(BigInteger.ONE.intValue(), candidate.getNumberOfVotes());
		}
	}
	
	private VotingRequest votingRequest() {
		return VotingRequest.builder()
				       .candidateParty("APC")
				       .vin(buildVoter().getVoterIdentificationNumber())
				       .build();
	}
	private VotingRequest votingRequest1() {
		return VotingRequest.builder()
				       .candidateParty("PDP")
				       .vin(buildVoter1().getVoterIdentificationNumber())
				       .build();
	}
	
	private CandidateResponse buildCandidate(){
		return candidateService.registerNewCandidateCandidate(CandidateRequest.builder()
				       .electionId(electionService.findAll().get(0).getId())
				       .partyId(buildParty().getId())
				       .candidateName("Tinubu")
				       .candidatePartyName("APC")
				       .build());
	}
	private CandidateResponse buildCandidate1(){
		CandidateService candidateService = CandidateServiceImplementation.getInstance();
		return candidateService.registerNewCandidateCandidate(CandidateRequest.builder()
				       .electionId(electionService.findAll().get(0).getId())
				       .partyId(buildParty1().getId())
				       .candidateName("Atiku")
				       .candidatePartyName("PDP")
				       .build());
	}
	private PartyResponse buildParty(){
		PartyService partyService = PartyServiceImplementation.getInstance();
		return partyService.registerNewPartyTest(PartyRequest.builder()
				                                  .password("Ole ni wa")
				                                  .partyUserName("APC")
				                                  .build());
	}
	private PartyResponse buildParty1(){
		PartyService partyService = PartyServiceImplementation.getInstance();
		return partyService.registerNewPartyTest(PartyRequest.builder()
				                                  .password("Ole ni wa but We never see chance")
				                                  .partyUserName("PDP")
				                                  .build());
	}
	
	private VoterCreationResponse buildVoter(){
		VoterCreationResponse response = null;
		try {
			response = voterService.registerNewVoter(VoterCreationRequest.builder()
					                                     .email("dominicrotimi@gmail.com")
					                                     .town("Oshodi")
					                                     .state("Anambra")
					                                     .name("Dominic Rotimi")
					                                     .age(24)
					                                     .gender("Male")
					                                     .street("Unknown")
					                                     .lga("Isolo")
					                                     .houseNumber("34B")
					                                     .password("coutinho10")
					                                     .userName("coutinho")
					                                     .build());
		}catch (FailedRegistrationException registrationException){
			System.out.println("ERROR: "+ registrationException);
		}
		return response;
	}
	private VoterCreationResponse buildVoter1(){
		VoterCreationResponse response = null;
		try {
			response = voterService.registerNewVoter(VoterCreationRequest.builder()
					                                     .email("coutinhodacruz10@gmail.com")
					                                     .town("Oshodi")
					                                     .state("Anambra")
					                                     .name("Dominic Onwukwufor")
					                                     .age(24)
					                                     .gender("Male")
					                                     .street("Unknown")
					                                     .lga("Isolo")
					                                     .houseNumber("34B")
					                                     .password("dacruz@10")
					                                     .userName("coutinho")
					                                     .build());
		}catch (FailedRegistrationException registrationException){
			System.out.println("ERROR: "+ registrationException);
		}
		return response;
	}
	
	@Test void testThatWhenElectionStopsVoterCanVoteFieldIsFalseAndCannotVoteFieldIsTrue(){
	
	}
	
	@Test void stopElectionTest(){
		
	}
}
