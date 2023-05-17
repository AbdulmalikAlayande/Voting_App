package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Party;
import africa.semicolon.notbvas.models.UserInformation;
import africa.semicolon.notbvas.utils.AppUtils.IdGenerator;
import africa.semicolon.notbvas.utils.AppUtils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartyRepositoryImpl implements PartyRepository{
	
	List<Party> listOfParties = new ArrayList<>();
	UserInformationRepository userInformationRepository = new UserInformationRepositoryImpl();
	@Override
	public Party findById(String id) {
		Party foundParty = null;
		for (Party party : listOfParties)
			if (Objects.equals(party.getId(), id)) foundParty = party;
		if (foundParty != null) {
			String userInformationId = Mapper.getLinkedUserInformationId(foundParty.getId());
			UserInformation userInformation = userInformationRepository.findById(userInformationId);
			foundParty.setUserInformation(userInformation);
		}
		return foundParty;
	}
	
	@Override
	public List<Party> findAll() {
		List<Party> foundPoliticalParties = new ArrayList<>();
		for (Party party : listOfParties) {
			String userInformationId = Mapper.getLinkedUserInformationId(party.getId());
			if (userInformationId != null)
				party.setUserInformation(userInformationRepository.findById(userInformationId));
			foundPoliticalParties.add(party);
		}
		return foundPoliticalParties;
	}
	
	@Override
	public Party save(Party party) {
		if (partyDoesNotExistInTheDatabase(party))
			saveNewParty(party);
		UserInformation userInformation = userInformationRepository.save(existingParty(party).getUserInformation());
		Mapper.linkUserToUserInformation(existingParty(party).getId(), userInformation.getId());
		return existingParty(party);
	}
	
	private boolean partyDoesNotExistInTheDatabase(Party party) {
		return !listOfParties.contains(party) || party.getId() == null;
	}
	
	private void saveNewParty(Party party) {
		party.setId(generatedId());
		listOfParties.add(party);
	}
	
	private String generatedId() {
		int party = listOfParties.size() + 1;
		return "Party"+party+ IdGenerator.getCharacter()+"ElluP"+"##VERIFIED##";
	}
	
	private Party existingParty(Party party) {
		return party;
	}
	
	@Override
	public boolean deleteById(String id) {
		Party foundParty = findById(id);
		if (foundParty != null) {
			listOfParties.remove(findById(id));
			return true;
		}
		return false;
	}
	
	@Override
	public int getCountOfAllParties() {
		return listOfParties.size();
	}
}
