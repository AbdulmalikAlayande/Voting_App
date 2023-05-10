package RepositoryTest;

import africa.semicolon.notbvas.models.Election;
import africa.semicolon.notbvas.repositories.ElectionRepositoryImplementation;
import africa.semicolon.notbvas.repositories.ElectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElectionRepositoryTest {
	
	private Election election;
	private ElectionRepository electionRepo;
	
	@BeforeEach void startAllTestWith(){
		election = new Election();
		electionRepo = new ElectionRepositoryImplementation();
	}
	
	@Test void saveElection_countIsIncrementedTest(){
	
	}
}