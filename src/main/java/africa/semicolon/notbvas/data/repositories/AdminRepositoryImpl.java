package africa.semicolon.notbvas.data.repositories;

import africa.semicolon.notbvas.data.models.Admin;
import africa.semicolon.notbvas.data.models.UserInformation;
import africa.semicolon.notbvas.utils.IdGenerator;
import africa.semicolon.notbvas.utils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminRepositoryImpl implements AdminRepository{
	private final List<Admin> listOfAdmins = new ArrayList<>();
	private final UserInformationRepository userInformationRepository = new UserInformationRepositoryImpl();
	@Override
	public Admin findById(String id) {
		Admin foundAdmin = null;
		for(Admin admin : listOfAdmins)
			if (Objects.equals(admin.getId(), id)) {
				foundAdmin = admin;
				String userInfoId = Mapper.getLinkedUserInformationId(foundAdmin.getId());
				foundAdmin.setUserInformation(userInformationRepository.findById(userInfoId));
			}
		return foundAdmin;
	}
	
	@Override
	public List<Admin> findAll() {
		List<Admin> savedAdmins = new ArrayList<>();
		for (Admin admin :listOfAdmins) {
			String userInfoId = Mapper.getLinkedUserInformationId(admin.getId());
			if (userInfoId != null)
				admin.setUserInformation(userInformationRepository.findById(userInfoId));
			savedAdmins.add(admin);
		}
		return savedAdmins;
	}
	
	@Override
	public Admin save(Admin admin) {
		if (adminDoesNotExist(admin))
			saveNewAdmin(admin);
		UserInformation savedUserInformation = userInformationRepository.save(existingAdmin(admin).getUserInformation());
		Mapper.linkUserToUserInformation(existingAdmin(admin).getId(),savedUserInformation.getId());
		return existingAdmin(admin);
	}
	
	private Admin existingAdmin(Admin admin) {
		return admin;
	}
	
	private void saveNewAdmin(Admin admin) {
		admin.setId(generatedId());
		listOfAdmins.add(admin);
	}
	
	private String generatedId() {
		int voter = getCountOfAllAdmins()+1;
		return "Admin"+voter+"-"+IdGenerator.getCharacter()+"#VERIFIED_ADMIN#";
	}
	
	private boolean adminDoesNotExist(Admin admin) {
		return !listOfAdmins.contains(admin) || admin.getId() == null;
	}
	
	@Override
	public void deleteById(String id) {
		listOfAdmins.remove(findById(id));
	}
	
	@Override
	public int getCountOfAllAdmins() {
		return listOfAdmins.size();
	}
}
