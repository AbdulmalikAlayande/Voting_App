package RepositoryTest;

import africa.semicolon.notbvas.data.models.Election;
import africa.semicolon.notbvas.data.repositories.ElectionRepository;
import africa.semicolon.notbvas.data.repositories.ElectionRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElectionRepositoryTest {
	
	private Election election;
	private ElectionRepository electionRepo;
	
	@BeforeEach void startAllTestWith(){
		election = new Election();
		electionRepo = new ElectionRepositoryImplementation();
	}
	
	@Test void saveElection_countIsIncrementedTest(){
		Election savedElection = electionRepo.save(election);
		assertEquals(election, savedElection);
		assertEquals(BigInteger.ONE.intValue(), electionRepo.findAll().size());
	}
	
	@Test void saveElectionMultipleTimesCountIsIncrementedTedTest(){
		Election savedElection = electionRepo.save(election);
		electionRepo.save(savedElection);
		assertEquals(election, savedElection);
		assertEquals(BigInteger.ONE.intValue(), electionRepo.findAll().size());
	}
	
	@Test void saveElection_FindELectionByIdTest(){
		Election savedElection = electionRepo.save(election);
		Election foundElection = electionRepo.findById(savedElection.getId());
		assertNotNull(foundElection);
		assertNotNull(foundElection.getId());
		assertEquals(election, savedElection);
		assertEquals(election, foundElection);
	}
	
	@Test void saveElection_DeleteELectionById(){
		Election savedElection = electionRepo.save(election);
		boolean isDeleted = electionRepo.deleteById(savedElection.getId());
		assertTrue(isDeleted);
		assertEquals(BigInteger.ZERO.intValue(), electionRepo.getCountOfAllElections());
	}
	
	@Test void findAllElectionsTest(){
		electionRepo.save(election);
		List<Election> electionList = new ArrayList<>();
		Election election1 = new Election();
		Election election2 = new Election();
		electionRepo.save(election1);
		electionRepo.save(election2);
		electionList.add(election1);
		electionList.add(election2);
		for (int i = 0; i < electionRepo.getCountOfAllElections(); i++) {
			assertNotNull(electionRepo.findAll().get(i));
		}
		assertEquals(BigInteger.valueOf(3).intValue(), electionRepo.findAll().size());
		assertEquals(electionList, electionRepo.findAll());
	}
}