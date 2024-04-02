package RepositoryTest;

import africa.semicolon.notbvas.data.models.Admin;
import africa.semicolon.notbvas.data.models.UserInformation;
import africa.semicolon.notbvas.data.repositories.AdminRepository;
import africa.semicolon.notbvas.data.repositories.AdminRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminRepositoryTest {
	AdminRepository adminRepository;
	UserInformation userInformation;
	Admin savedAdmin;
	Admin admins;
	
	@BeforeEach void startAllTestWith(){
		admins = new Admin();
		userInformation = new UserInformation();
		adminRepository = new AdminRepositoryImpl();
		userInformation.setPassword("falz");
		userInformation.setUserName("MDK");
		admins.setUserInformation(userInformation);
		savedAdmin = adminRepository.save(admins);
	}
	
	@Test void saveNewAdmin_CountIsIncrementedTest(){
		assertNotNull(savedAdmin);
		assertNotNull(savedAdmin.getId());
		assertEquals(BigInteger.valueOf(adminRepository.getCountOfAllAdmins()).intValue(), adminRepository.getCountOfAllAdmins());
	}
	
	@Test void saveAdminMultipleTimes_CountDoesNotIncrementTest(){
		adminRepository.save(savedAdmin);
		assertEquals(BigInteger.ONE.intValue(), adminRepository.getCountOfAllAdmins());
	}
	
	@Test void saveAdmin_FindSavedAdminByIdTest(){
		assertNotNull(adminRepository.findById(savedAdmin.getId()));
		assertNotNull(adminRepository.findById(savedAdmin.getId()).getId());
	}
	
	@Test void saveAdmin_DeleteAdminByIdTest(){
		adminRepository.deleteById(savedAdmin.getId());
		assertEquals(BigInteger.ZERO.intValue(), adminRepository.getCountOfAllAdmins());
	}
	
	@Test void getAllAdminsTest(){
		Admin admin = new Admin();
		UserInformation userInformation1 = new UserInformation();
		userInformation1.setUserName("Maleek Berry");
		userInformation1.setPassword("Bahd Guys");
		admin.setUserInformation(userInformation1);
		Admin admin1 = new Admin();
		UserInformation userInformation2 = new UserInformation();
		userInformation2.setPassword("I am about to be the young deliro");
		userInformation2.setUserName("I thank Allah That i am alive");
		admin1.setUserInformation(userInformation2);
		adminRepository.save(admin);
		adminRepository.save(admin1);
		List<Admin> listOfAdminExpectedToBeInTheDatabase = new ArrayList<>();
		listOfAdminExpectedToBeInTheDatabase.add(savedAdmin);
		listOfAdminExpectedToBeInTheDatabase.add(admin);
		listOfAdminExpectedToBeInTheDatabase.add(admin1);
		for (int i = 0; i < adminRepository.findAll().size(); i++)
			assertNotNull(adminRepository.findAll().get(i));
		assertEquals(listOfAdminExpectedToBeInTheDatabase, adminRepository.findAll());
		assertEquals(BigInteger.valueOf(3).intValue(), adminRepository.getCountOfAllAdmins());
	}
	
	
}