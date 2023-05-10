package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Address;

import java.util.List;

public interface AddressRepository {
	
	Address findById(String id);
	List<Address> findAll();
	Address save(Address address);
	void deleteById(String id);
	
	int getCountOfAllParties();
}
