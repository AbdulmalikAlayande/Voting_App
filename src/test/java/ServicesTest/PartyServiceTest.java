package ServicesTest;

import africa.semicolon.notbvas.Sevices.PartyService;
import africa.semicolon.notbvas.Sevices.PartyServiceImplementation;
import africa.semicolon.notbvas.dtos.request.PartyRequest;
import africa.semicolon.notbvas.dtos.response.PartyResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartyServiceTest {
	
	PartyService partyService;
	PartyResponse returnedResponse;
	PartyRequest partyRequest;
	@BeforeEach void setUp() {
		partyService = new PartyServiceImplementation();
		partyRequest = PartyRequest.builder()
				               .partyUserName("APC")
				               .password("broomIsOurStealingWeapon")
				               .build();
		returnedResponse = partyService.registerNewPartyTest(partyRequest);
	}
	
	@Test void registerNewPartyTest(){
		assertNotNull(returnedResponse);
		assertEquals(BigInteger.ONE.intValue(), partyService.findAll().size());
	}
	
	@Test void findByIdTest(){
		PartyResponse foundPartyResponse = partyService.findById(partyService.findAll().get(partyService.findAll().size() - 1).getId());
		PartyResponse foundPartyResponse2 = partyService.findById(returnedResponse.getId());
		assertNotNull(foundPartyResponse);
		assertNotNull(foundPartyResponse.getId());
		assertEquals(foundPartyResponse2, foundPartyResponse);
	}
	
	@Test void deleteByIdTest(){
		String deleteResponse = partyService.deleteById(returnedResponse.getId());
		assertEquals("Deleted Successfully", deleteResponse);
		assertNotEquals("Error: not deleted", deleteResponse);
		assertEquals(BigInteger.ZERO.intValue(), partyService.findAll().size());
	}
	
	@Test void findAllTest(){
		PartyRequest partyRequest2 = PartyRequest.builder()
				                             .partyUserName("APC")
				                             .password("Thieves")
				                             .build();
		PartyResponse response2 = partyService.registerNewPartyTest(partyRequest2);
		List<PartyResponse> expectedParties = new ArrayList<>();
		expectedParties.add(returnedResponse);
		expectedParties.add(response2);
		for (int i = 0; i < partyService.findAll().size(); i++)
			assertNotNull(partyService.findAll().get(i));
		assertEquals(expectedParties, partyService.findAll());
		assertEquals(BigInteger.TWO.intValue(), partyService.findAll().size());
	}
}