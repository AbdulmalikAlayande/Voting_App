package RepositoryTest;

import africa.semicolon.notbvas.data.models.Candidate;
import africa.semicolon.notbvas.data.repositories.CandidateRepository;
import africa.semicolon.notbvas.data.repositories.CandidateRepositoryImplementation;
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateRepositoryTest {
	
	Candidate candidate;
	Candidate savedCandidate;
	CandidateRepository candidateRepository;
	@BeforeEach void startAllTestWith(){
		candidate = new Candidate();
		candidateRepository = new CandidateRepositoryImplementation();
		candidate.setCandidateName("Amebo");
		candidate.setElectionId("Prototype");
		savedCandidate = candidateRepository.saveCandidate(candidate);
	}
	
	@Test void saveNewCandidate_CountIsIncrementedTest(){
		assertEquals(BigInteger.ONE.intValue(), candidateRepository.getAllCandidatesInTheDatabase().size());
	}
	
	@Test void saveCandidateMultipleTimes_CountDoesNotIncrementTest(){
		candidateRepository.saveCandidate(savedCandidate);
		assertEquals(BigInteger.ONE.intValue(), candidateRepository.getAllCandidatesInTheDatabase().size());
	}
	
	@Test void findCandidateByIdTest(){
		Candidate foundCandidate = candidateRepository.findCandidateBy(savedCandidate.getId());
		assertNotNull(foundCandidate);
		assertNotNull(foundCandidate.getId());
	}
	
	@Test void findCandidateByNameTest(){
		Candidate foundCandidate = candidateRepository.findCandidateByName(savedCandidate.getCandidateName());
		assertNotNull(foundCandidate);
		assertNotNull(foundCandidate.getCandidateName());
	}
	
	@Test void getCandidatesByElectionIdTest(){
		List<Candidate> candidates = new ArrayList<>();
		Candidate candidate1 = new Candidate();
		candidate1.setElectionId("Prototype");
		Candidate savedCandidate2 = candidateRepository.saveCandidate(candidate1);
		candidates.add(savedCandidate);
		candidates.add(savedCandidate2);
		for (int i = 0; i < candidateRepository.getCandidatesByElectionId("Prototype").size(); i++) {
			assertNotNull(candidateRepository.getCandidatesByElectionId("Prototype").get(i));
		}
		assertEquals(BigInteger.TWO.intValue(), candidateRepository.getCandidatesByElectionId("Prototype").size());
		assertEquals(candidates, candidateRepository.getCandidatesByElectionId("Prototype"));
	}
	
	@Test void getAllCandidatesInTheDataBaseTest(){
		List<Candidate> candidates = new ArrayList<>();
		Candidate candidate1 = new Candidate();
		candidate1.setElectionId("Prototype");
		Candidate savedCandidate2 = candidateRepository.saveCandidate(candidate1);
		candidates.add(savedCandidate);
		candidates.add(savedCandidate2);
		for (int i = 0; i < candidateRepository.getAllCandidatesInTheDatabase().size(); i++) {
			assertNotNull(candidateRepository.getAllCandidatesInTheDatabase().get(i));
		}
		assertEquals(BigInteger.TWO.intValue(), candidateRepository.getAllCandidatesInTheDatabase().size());
		assertEquals(candidates, candidateRepository.getAllCandidatesInTheDatabase());
	}
	
	@Test void deleteCandidateByIdTest(){
		boolean isDeleted = candidateRepository.deleteCandidateBy(candidate.getId());
		assertTrue(isDeleted);
		assertEquals(BigInteger.ZERO.intValue(), candidateRepository.getAllCandidatesInTheDatabase().size());
	}
}
