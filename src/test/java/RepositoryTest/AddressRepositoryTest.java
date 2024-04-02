package RepositoryTest;

import africa.semicolon.notbvas.data.models.Address;
import africa.semicolon.notbvas.data.repositories.AddressRepository;
import africa.semicolon.notbvas.data.repositories.AddressRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddressRepositoryTest {
	
	AddressRepository addressRepository;
	Address address;
	Address savedAddress;
	
	
	@BeforeEach
	void startAllTestWith(){
		addressRepository = new AddressRepositoryImpl();
		address = new Address();
		savedAddress = addressRepository.save(address);
	}
	
	@Test
	void saveNewParty_CountIsIncremented(){
		assertNotNull(savedAddress);
		assertEquals(BigInteger.ONE.intValue(), addressRepository.getCountOfAllParties());
	}
	
	@Test void savePartyMultipleTimes_CountDoesNotIncrementTest(){
		addressRepository.save(savedAddress);
		addressRepository.save(address);
		assertEquals(BigInteger.valueOf(addressRepository.getCountOfAllParties()).intValue(), addressRepository.getCountOfAllParties());
	}
	
	@Test void saveParty_FindPartyBYIdTest(){
		assertNotNull(addressRepository.findById(address.getId()));
		assertNotNull(addressRepository.findById(address.getId()).getId());
	}
	
	@Test void saveParty_RemovePartyBYIdTest(){
		addressRepository.deleteById(savedAddress.getId());
		assertEquals(BigInteger.ZERO.intValue(), addressRepository.getCountOfAllParties());
	}
	
	@Test void getAllRegisteredPartiesTest(){
		Address address1 = new Address();
		addressRepository.save(address1);
		List<Address> expectedParties = new ArrayList<>();
		expectedParties.add(address);
		expectedParties.add(address1);
		for (int i = 0; i < addressRepository.findAll().size(); i++)
			assertNotNull(addressRepository.findAll().get(i));
		assertEquals(expectedParties, addressRepository.findAll());
	}
}