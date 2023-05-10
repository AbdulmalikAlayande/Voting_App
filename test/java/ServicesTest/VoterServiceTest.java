package ServicesTest;

import africa.semicolon.notbvas.Sevices.VoterService;
import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.VoterResponse;
import africa.semicolon.notbvas.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoterServiceTest {
	
	private VoterService voterService;
	private VoterRequest voterRequest;
	Voter voter;
	@BeforeEach
	void setUp() {
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
				               .gender("Male")
				               .build();
		voterService.registerNewVoter(voterRequest);
	}
	
	@Test void registrationTest(){
	
	}
}
/*voterRequest = new VoterRequest();
		voterRequest.setAge(20);
		voterRequest.setLga("Sabo");
		voterRequest.setName("Abdulmalik");
		voterRequest.setHouseNumber("43");
		voterRequest.setGender("Male");
		voterRequest.setPassword("ayanniyi20");
		voterRequest.setState("Ogun");
		voterRequest.setStreet("edo inside");
		voterRequest.setTown("Ijako");
		voterResponse = new VoterResponse();*/