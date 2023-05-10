package RepositoryTest;

import africa.semicolon.notbvas.models.UserInformation;
import africa.semicolon.notbvas.repositories.UserInformationRepository;
import africa.semicolon.notbvas.repositories.UserInformationRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInformationRepositoryTest {
	UserInformation userInfo;
	UserInformationRepository userInfoRepo;
	UserInformation savedUser;

	@BeforeEach void startAllTestWith(){
		userInfo = new UserInformation();
		userInfoRepo = new UserInformationRepositoryImpl();
		savedUser = userInfoRepo.save(userInfo);
	}
	
	@Test void saveNewUserInfo_CountIsIncrementedTest() {
		assertNotNull(userInfo.getId());
		assertEquals(BigInteger.valueOf(userInfoRepo.getCount()).intValue(), userInfoRepo.getCount());
	}
	
	@Test void saveUserInfoMultipleTimes_CountDoesNotIncrementTest(){
		userInfoRepo.save(savedUser);
		assertEquals(BigInteger.valueOf(1).intValue(), userInfoRepo.getCount());
	}
	
	@Test void saveUserInfo_FindUserInfoByIdTest(){
		assertNotNull(userInfoRepo.findById(userInfo.getId()));
		assertNotNull(userInfoRepo.findById(userInfo.getId()).getId());
	}
	
	@Test void saveUserInfo_DeleteUserInfoByIdTest(){
		userInfoRepo.deleteById(userInfo.getId());
		assertEquals(BigInteger.valueOf(0).intValue(), userInfoRepo.getCount());
	}
	
	@Test void findAllUserInfoTest(){
		UserInformation userInformation = new UserInformation();
		userInfoRepo.save(userInformation);
		List<UserInformation> userInformations = new ArrayList<>();
		userInformations.add(savedUser);
		userInformations.add(userInformation);
		for (int i = 0; i < userInfoRepo.findAll().size(); i++) {
			assertNotNull(userInfoRepo.findAll().get(i));
		}
		assertEquals(BigInteger.valueOf(userInfoRepo.getCount()).intValue(), userInfoRepo.getCount());
		assertEquals(userInformations, userInfoRepo.findAll());
	}
}