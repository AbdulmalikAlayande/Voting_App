package ServicesTest;

import africa.semicolon.notbvas.Sevices.AdminService;
import africa.semicolon.notbvas.Sevices.AdminServiceImplementation;
import africa.semicolon.notbvas.Sevices.CandidateService;
import africa.semicolon.notbvas.Sevices.CandidateServiceImplementation;
import africa.semicolon.notbvas.data.dtos.request.AdminRequest;
import africa.semicolon.notbvas.data.dtos.request.ElectionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

public class AdminServiceTest {
	
	AdminService adminService;
	CandidateService candidateService;
	ElectionRequest electionRequest;
	AdminRequest adminRequest;
	@BeforeEach void startAllTestWith(){
		adminRequest = AdminRequest.builder()
				               .name("Abolade")
				               .password("ayanniyi@20")
				               .build();
//		electionRequest = ElectionRequest
		adminService = AdminServiceImplementation.getInstance();
		candidateService = CandidateServiceImplementation.getInstance();
	}
	
	@Test void registerNewAdminTest(){
	
	}
}
