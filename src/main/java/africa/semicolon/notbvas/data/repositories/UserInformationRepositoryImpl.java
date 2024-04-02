package africa.semicolon.notbvas.data.repositories;

import africa.semicolon.notbvas.data.models.UserInformation;
import africa.semicolon.notbvas.utils.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserInformationRepositoryImpl implements UserInformationRepository{
	List<UserInformation> userInformationList = new ArrayList<>();
	@Override
	public UserInformation findById(String id) {
		for (UserInformation userInformation : userInformationList)
			if (Objects.equals(userInformation.getId(), id)) return userInformation;
		return null;
	}
	
	@Override
	public List<UserInformation> findAll() {
		return userInformationList;
	}
	
	@Override
	public UserInformation save(UserInformation userInformation) {
		if (userInformationDoesNotExistInTheDatabase(userInformation))
			saveTheNewUserInformation(userInformation);
		return savedAndExistingUserInformation(userInformation);
	}
	
	private UserInformation savedAndExistingUserInformation(UserInformation userInformation) {
		return userInformation;
	}
	
	private void saveTheNewUserInformation(UserInformation userInformation) {
		userInformation.setId(generatedId());
		userInformationList.add(userInformation);
	}
	
	private String generatedId() {
		int userInfo = userInformationList.size() + 1;
		return "UserInfo--"+userInfo+IdGenerator.getCharacter()+"#created#";
	}
	
	private boolean userInformationDoesNotExistInTheDatabase(UserInformation userInformation) {
		return !userInformationList.contains(userInformation) || userInformation.getId() == null;
	}
	
	@Override
	public void deleteById(String id) {
		userInformationList.remove(findById(id));
	}
	
	@Override
	public int getCount() {
		return userInformationList.size();
	}
}
