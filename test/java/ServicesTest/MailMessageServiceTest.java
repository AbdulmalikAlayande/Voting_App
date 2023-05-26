package ServicesTest;

import africa.semicolon.notbvas.Sevices.MailMessageImplementation;
import africa.semicolon.notbvas.Sevices.MailMessageService;
import africa.semicolon.notbvas.Sevices.VoterService;
import africa.semicolon.notbvas.Sevices.VoterServiceImplementation;
import africa.semicolon.notbvas.dtos.request.VoterCreationRequest;
import africa.semicolon.notbvas.exceptions.registration_exception.FailedRegistrationException;
import africa.semicolon.notbvas.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MailMessageServiceTest {
	List<Voter> allVoters;
	MailMessageService messageService;
	VoterService voterService;
	@BeforeEach void setUp() {
		voterService = VoterServiceImplementation.getInstance();
		try {
			System.out.println(voterService.registerNewVoter(voter1()));
			System.out.println(voterService.registerNewVoter(voter2()));
			System.out.println(voterService.registerNewVoter(voter3()));
			System.out.println(voterService.registerNewVoter(voter4()));
		}catch (RuntimeException | FailedRegistrationException exception){
			System.out.println(exception.getMessage());
			System.out.println(exception.getLocalizedMessage());
			System.out.println(exception.getClass());
			exception.printStackTrace();
		}
		voterService = VoterServiceImplementation.getInstance();
		messageService = MailMessageImplementation.getInstance();
		allVoters = voterService.getAllVoterObjects();
	}
	
	@Test void notifyAllUsersThatElectionHasStartedTest(){
		Voter[] arrayOfVoters = new Voter[allVoters.size()];
		for (int i = 0; i < allVoters.size(); i++) {
			if (allVoters.get(i).getEmail() != null)
				arrayOfVoters[i] = allVoters.get(i);
		}
		boolean allUsersHaveBeenNotified = messageService.notifyUsersThatElectionHasStarted(arrayOfVoters);
		assertTrue(allUsersHaveBeenNotified);
		assertEquals(BigInteger.valueOf(4).intValue(), voterService.getCountOfAllVoters() );
	}
	
	private VoterCreationRequest voter1(){
		return VoterCreationRequest.builder()
				       .age(61)
				       .lga("Irepodun")
				       .name("Onwukufor Document")
				       .houseNumber("43")
				       .state("Ogun")
				       .street("edo inside")
				       .town("Ijako")
				       .password("oseni 1")
				       .gender("Male")
				       .userName("oseni@61")
				       .email("dominicrotimi@gmail.com")
				       .build();
	}
	private VoterCreationRequest voter2(){
			return VoterCreationRequest.builder()
					       .age(24)
					       .lga("Sabo")
					       .name("Obinali Goodness")
					       .houseNumber("34")
					       .state("Ogun")
					       .street("One side for dopemu sha")
					       .town("Dopemu")
					       .password("obinali@goodness")
					       .gender("Male")
					       .userName("goodness@19")
					       .email("coutinhodacruz10@gmail.com")
					       .build();
	}
	private VoterCreationRequest voter3(){
			return VoterCreationRequest.builder()
					       .age(24)
					       .lga("Sabo")
					       .name("Alayande Zainab")
					       .houseNumber("34")
					       .state("Ogun")
					       .street("27B Fatai Atere way Matori Mushin Lagos")
					       .town("Matori")
					       .password("zainab@alayande")
					       .gender("Female")
					       .userName("zainab@24")
					       .email("alayandezainab64@gmail.com")
					       .build();
	}
	private VoterCreationRequest voter4(){
			return VoterCreationRequest.builder()
					       .age(22)
					       .lga("Ado Odo Otta")
					       .name("Alayande Sophia")
					       .houseNumber("34")
					       .state("Ogun")
					       .street("27B Fatai Atere way Matori Mushin Lagos")
					       .town("Matori")
					       .password("sophia@alayande")
					       .gender("Female")
					       .userName("sophia@22")
					       .email("alayandesophia2019@gmail.com")
					       .build();
	}
}