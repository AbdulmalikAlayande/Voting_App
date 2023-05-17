package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.AdminRequest;
import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.request.ElectionRequest;
import africa.semicolon.notbvas.dtos.response.AdminResponse;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.models.Candidate;
import africa.semicolon.notbvas.models.Election;

import java.util.List;

public class AdminServiceImplementation implements AdminService{
	
	@Override
	public AdminResponse registerAdmin(AdminRequest adminRequest) {
		return null;
	}
	
	@Override
	public AdminResponse updateAdmin(AdminRequest adminRequest) {
		return null;
	}
	
	@Override
	public String deleteAdmin(String adminId) {
		return null;
	}
	
	@Override
	public AdminResponse getAdminById(String adminId) {
		return null;
	}
	
	@Override
	public List<AdminResponse> getAllAdmins() {
		return null;
	}
	
	@Override
	public ElectionResponse createElection(ElectionRequest electionRequest) {
		return null;
	}
	
	@Override
	public ElectionResponse updateElection(ElectionRequest electionRequest) {
		return null;
	}
	
	@Override
	public String deleteElection(String electionId) {
		return null;
	}
	
	@Override
	public List<ElectionResponse> getAllElections() {
		return null;
	}
	
	@Override
	public Election getElectionsById(String electionId) {
		return null;
	}
	
	@Override
	public CandidateResponse createCandidate(CandidateRequest candidateRequest) {
		return null;
	}
	
	@Override
	public CandidateResponse updateCandidate(CandidateRequest candidateRequest) {
		return null;
	}
	
	@Override
	public String deleteCandidate(String candidateId) {
		return null;
	}
	
	@Override
	public Candidate getCandidatesByElectionId(String candidateId) {
		return null;
	}
	
	@Override
	public int getVoteCountForCandidateByCandidateId(String candidateId) {
		return 0;
	}
	
	@Override
	public int getAllVoteCountForAParticularElection() {
		return 0;
	}
}
