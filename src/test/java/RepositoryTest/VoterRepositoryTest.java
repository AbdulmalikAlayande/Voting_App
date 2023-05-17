package RepositoryTest;

import africa.semicolon.notbvas.models.UserInformation;
import africa.semicolon.notbvas.models.Voter;
import africa.semicolon.notbvas.repositories.VoterRepository;
import africa.semicolon.notbvas.repositories.VoterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoterRepositoryTest {
	
	VoterRepository voterRepository;
	Voter voter;
	Voter savedVoter;
	UserInformation userInformation;
	@BeforeEach void startAllTestWith(){
		voterRepository = new VoterRepositoryImpl();
		voter = new Voter();
		userInformation = new UserInformation();
		userInformation.setUserName("Ben10");
		userInformation.setPassword("Man ah");
		voter.setUserInfo(userInformation);
		savedVoter = voterRepository.save(voter);
	}
	
	@Test void saveNewVoter_COuntIsIncrementedTest(){
	}
	
	@Test void saveNewVoter_CountIsIncrementedTest(){
		assertNotNull(savedVoter);
		assertNotNull(savedVoter.getId());
		assertEquals(1, voterRepository.getCountOfAllVoters());
	}
	
	@Test void saveAVoterMultipleTimes_CountDoesNotIncrementTest(){
		voterRepository.save(savedVoter);
		assertNotNull(savedVoter.getId());
		assertEquals(1, voterRepository.getCountOfAllVoters());
	}
	
	@Test void saveNewVoter_findVoterByIdTest(){
		Voter foundVoter = voterRepository.findById(savedVoter.getId());
		assertNotNull(foundVoter.getId());
		assertNotNull(foundVoter);
	}
	
	@Test void getAllVotersSavedInTheRepositoryTest(){
		Voter voter1 = new Voter();
		UserInformation userInformation1 = new UserInformation();
		userInformation1.setUserName("Ben10");
		userInformation1.setPassword("Man ah");
		voter1.setUserInfo(userInformation1);
		voterRepository.save(voter1);
		List<Voter> expectedVoters = new ArrayList<>();
		expectedVoters.add(voter);
		expectedVoters.add(voter1);
		for (int i = 0; i < voterRepository.findAll().size(); i++) {
			assertNotNull(voterRepository.findAll().get(i));
		}
		assertEquals(expectedVoters, voterRepository.findAll());
	}
	
	@Test void saveNewVoter_DeleteSavedVoterByIdTest(){
		String name2 = "elites";
		String name = new String("elites").intern();
		System.out.println(name == name2);
		voterRepository.deleteById(savedVoter.getId());
		assertEquals(0, voterRepository.getCountOfAllVoters());
	}
}