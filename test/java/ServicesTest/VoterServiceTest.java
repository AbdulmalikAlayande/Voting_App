package ServicesTest;

import africa.semicolon.notbvas.Sevices.VoterService;
import africa.semicolon.notbvas.Sevices.VoterServiceImplementation;
import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.VoterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoterServiceTest {
	
	private VoterService voterService;
	private VoterRequest voterRequest;
	VoterResponse voterResponse;
	@BeforeEach
	void setUp() {
		voterService = new VoterServiceImplementation();
		voterRequest = new VoterRequest();
		voterRequest = VoterRequest.builder()
				               .age(20)
				               .lga("Sabo")
				               .name("Abdulmalik")
				               .houseNumber("43")
				               .state("Ogun")
				               .street("edo inside")
				               .town("Ijako")
				               .password("ayanniyi20")
				               .gender("MALE")
				               .userName("abdulmalik@20")
				               .build();
		voterResponse = voterService.registerNewVoter(voterRequest);
	}
	
	@Test void registrationTest(){
		assertNotNull(voterResponse);
		assertEquals(BigInteger.valueOf(voterService.getCountOfAllVoters()).intValue(), voterService.getCountOfAllVoters());
		assertEquals(BigInteger.ONE.intValue(), voterService.getCountOfAllVoters());
		System.out.println(voterResponse);
	}
	
	@Test void findByIdTest(){
	
	}
	
	@Test void getAllVotersTest(){
		VoterResponse voterResponse1 = voterService.registerNewVoter(VoterRequest.builder()
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
		List<VoterResponse> voterResponseList = new ArrayList<>();
		voterResponseList.add(voterResponse);
		voterResponseList.add(voterResponse1);
		for (int i = 0; i < voterService.getAllVoters().size(); i++) {
			assertNotNull(voterService.getAllVoters().get(i));
		}
		assertEquals(voterResponseList, voterService.getAllVoters());
		assertEquals(BigInteger.TWO.intValue(), voterService.getCountOfAllVoters());
	}
}
