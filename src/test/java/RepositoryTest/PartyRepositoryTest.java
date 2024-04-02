package RepositoryTest;

import africa.semicolon.notbvas.data.models.Party;
import africa.semicolon.notbvas.data.models.UserInformation;
import africa.semicolon.notbvas.data.repositories.PartyRepository;
import africa.semicolon.notbvas.data.repositories.PartyRepositoryImpl;
import africa.semicolon.notbvas.data.repositories.UserInformationRepository;
import africa.semicolon.notbvas.data.repositories.UserInformationRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartyRepositoryTest {
	    PartyRepository partyRepository;
		UserInformationRepository userInformationRepository;
		Party party;
		Party savedParty;
		UserInformation userInformation;
	 
	@BeforeEach void startAllTestWith(){
		userInformationRepository = new UserInformationRepositoryImpl();
		partyRepository = new PartyRepositoryImpl();
		userInformation = new UserInformation();
		party = new Party();
		party.setUserInformation(userInformation);
		savedParty = partyRepository.save(party);
	}
	
	@Test void saveNewParty_CountIsIncremented(){
		assertNotNull(savedParty);
		assertEquals(BigInteger.ONE.intValue(), partyRepository.getCountOfAllParties());
	}
	
	@Test void savePartyMultipleTimes_CountDoesNotIncrementTest(){
		partyRepository.save(savedParty);
		partyRepository.save(party);
		assertEquals(BigInteger.valueOf(partyRepository.getCountOfAllParties()).intValue(), partyRepository.getCountOfAllParties());
	}
	
	@Test void saveParty_FindPartyBYIdTest(){
		assertNotNull(partyRepository.findById(party.getId()));
		assertNotNull(partyRepository.findById(party.getId()).getId());
	}
	
	@Test void saveParty_RemovePartyBYIdTest(){
		partyRepository.deleteById(savedParty.getId());
		assertEquals(BigInteger.ZERO.intValue(), partyRepository.getCountOfAllParties());
	}
	
	@Test void getAllRegisteredPartiesTest(){
		Party pdp = new Party();
		UserInformation userInformation1 = new UserInformation();
		pdp.setUserInformation(userInformation1);
		partyRepository.save(pdp);
		List<Party> expectedParties = new ArrayList<>();
		expectedParties.add(party);
		expectedParties.add(pdp);
		for (int i = 0; i < partyRepository.findAll().size(); i++)
			assertNotNull(partyRepository.findAll().get(i));
		assertEquals(expectedParties, partyRepository.findAll());
	}
}