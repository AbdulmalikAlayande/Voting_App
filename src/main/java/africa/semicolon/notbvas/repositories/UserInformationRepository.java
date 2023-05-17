package africa.semicolon.notbvas.repositories;
import africa.semicolon.notbvas.models.UserInformation;

import java.util.List;

public interface UserInformationRepository {
	UserInformation findById(String id);
	List<UserInformation> findAll();
	UserInformation save(UserInformation userInformation);
	void deleteById(String id);
	int getCount();
}
