package africa.semicolon.notbvas.repositories;
import africa.semicolon.notbvas.models.UserInformation;
import africa.semicolon.notbvas.models.Voter;
import africa.semicolon.notbvas.utils.AppUtils.IdGenerator;
import africa.semicolon.notbvas.utils.AppUtils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VoterRepositoryImpl implements VoterRepository{
	private final List<Voter> listOfVoters = new ArrayList<>();
	private final UserInformationRepository userInformationRepository = new UserInformationRepositoryImpl();
	
	@Override
	public Voter findById(String id) {
		Voter foundVoter = null;
		for(Voter voter : listOfVoters) if (Objects.equals(voter.getId(), id))
				foundVoter = voter;
		
		if (foundVoter != null) {
			String userInfoId = Mapper.getLinkedUserInformationId(foundVoter.getId());
			foundVoter.setUserInfo(userInformationRepository.findById(userInfoId));
		}
		return foundVoter;
	}
	
	@Override
	public Voter save(Voter voter) {
		if (voterDoesNotExist(voter))
			saveNewVoter(voter);
		UserInformation userInfoOTheExistingVoter = existingVoter(voter).getUserInfo();
		UserInformation savedInfo = userInformationRepository.save(userInfoOTheExistingVoter);
		Mapper.linkUserToUserInformation(existingVoter(voter).getId(), savedInfo.getId());
		return existingVoter(voter);
	}
	
	@Override
	public List<Voter> findAll() {
		List<Voter> foundVoters = new ArrayList<>();
		for (Voter voter : listOfVoters) {
			String voterId = voter.getId();
			String userInformationId = Mapper.getLinkedUserInformationId(voterId);
			if (userInformationId != null) {
				UserInformation foundUserInfo = userInformationRepository.findById(userInformationId);
				voter.setUserInfo(foundUserInfo);
			}
			foundVoters.add(voter);
		}
		return foundVoters;
	}
	
	private boolean voterDoesNotExist(Voter voter) {
		return !listOfVoters.contains(voter) || voter.getId() == null;
	}
	
	private void saveNewVoter(Voter voter) {
		voter.setId(generatedId());
		listOfVoters.add(voter);
	}
	
	private String generatedId() {
		int voter = getCountOfAllVoters()+1;
		return "Voter"+voter+"-"+IdGenerator.getCharacter();
	}
	
	private Voter existingVoter(Voter voter) {
		return voter;
	}
	
	@Override
	public boolean deleteById(String id) {
		Voter voterToBeDeleted = findById(id);
		if (voterToBeDeleted != null) {
			listOfVoters.remove(voterToBeDeleted);
			return true;
		}
		return false;
	}
	
	@Override
	public int getCountOfAllVoters() {
		return listOfVoters.size();
	}
}
