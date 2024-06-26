package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.data.dtos.request.AdminRequest;
import africa.semicolon.notbvas.data.dtos.request.ElectionRequest;
import africa.semicolon.notbvas.data.dtos.response.AdminResponse;
import africa.semicolon.notbvas.data.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.data.models.Candidate;
import africa.semicolon.notbvas.data.models.Election;

import java.util.List;

public interface AdminService{
	AdminResponse registerAdmin(AdminRequest adminRequest);
	AdminResponse updateAdmin(AdminRequest adminRequest);
	String deleteAdmin(String adminId);
	AdminResponse getAdminById(String adminId);
	List<AdminResponse> getAllAdmins();
	ElectionResponse createElection(ElectionRequest electionRequest);
	ElectionResponse updateElection(ElectionRequest electionRequest);
	String deleteElection(String electionId);
	List<ElectionResponse>getAllElections();
	Election getElectionsById(String electionId);
	
	String deleteCandidate(String candidateId);
	Candidate getCandidatesByElectionId(String candidateId);
//	getElectionResults();
	int getVoteCountForCandidateByCandidateId(String candidateId);
	int getAllVoteCountForAParticularElection();
}
