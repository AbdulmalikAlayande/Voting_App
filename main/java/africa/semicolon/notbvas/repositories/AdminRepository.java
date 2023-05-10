package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Address;
import africa.semicolon.notbvas.models.Admin;

import java.util.List;

public interface AdminRepository {
	
	Admin findById(String id);
	List<Admin> findAll();
	Admin save(Admin address);
	void deleteById(String id);
	
	int getCountOfAllAdmins();
}
