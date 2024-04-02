package africa.semicolon.notbvas.data.repositories;

import africa.semicolon.notbvas.data.models.Admin;

import java.util.List;

public interface AdminRepository {
	
	Admin findById(String id);
	List<Admin> findAll();
	Admin save(Admin address);
	void deleteById(String id);
	
	int getCountOfAllAdmins();
}
