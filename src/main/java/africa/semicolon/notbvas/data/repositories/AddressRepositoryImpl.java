package africa.semicolon.notbvas.data.repositories;

import africa.semicolon.notbvas.data.models.Address;
import africa.semicolon.notbvas.utils.IdGenerator;
import africa.semicolon.notbvas.utils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressRepositoryImpl implements AddressRepository{
	List<Address> listOfAddress = new ArrayList<>();
	UserInformationRepository userInformationRepository = new UserInformationRepositoryImpl();
	
	@Override
	public Address findById(String id) {
		for (Address address : listOfAddress)
			if (Objects.equals(address.getId(), id)) {
				String userInfoId = Mapper.getLinkedUserInformationId(address.getId());
//				address.setuserInformationRepository.findById(userInfoId)
				return address;
			}
		return null;
	}
	
	@Override
	public List<Address> findAll() {
		return listOfAddress;
	}
	
	@Override
	public Address save(Address address) {
		if (addressIsNotSaved(address))
			saveNewAddress(address);
		return existingAddress(address);
	}
	
	private Address existingAddress(Address address) {
		return address;
	}
	
	private void saveNewAddress(Address address) {
		address.setId(generatedId());
		listOfAddress.add(address);
	}
	
	private String generatedId() {
		int address = listOfAddress.size() + 1;
		return "Address-"+address+ IdGenerator.getCharacter()+"#Verified#";
	}
	
	private boolean addressIsNotSaved(Address address) {
		return !listOfAddress.contains(address) || address.getId() == null;
	}
	
	@Override
	public void deleteById(String id) {
		listOfAddress.remove(findById(id));
	}
	
	@Override
	public int getCountOfAllParties() {
		return listOfAddress.size();
	}
}
