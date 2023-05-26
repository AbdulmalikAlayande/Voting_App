package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.dtos.request.CandidateRequest;
import africa.semicolon.notbvas.dtos.request.updateRequest.CandidateUpdateRequest;
import africa.semicolon.notbvas.dtos.response.CandidateResponse;
import africa.semicolon.notbvas.exceptions.registration_exception.RequestNotFoundException;
import africa.semicolon.notbvas.models.Candidate;
import africa.semicolon.notbvas.repositories.CandidateRepository;
import africa.semicolon.notbvas.repositories.CandidateRepositoryImplementation;
import africa.semicolon.notbvas.utils.AppUtils.CandidateMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CandidateServiceImplementation implements CandidateService{
	private static CandidateService instance = null;
	private CandidateServiceImplementation(){}
	
	public static CandidateService getInstance() {
		if (instance == null)
			return new CandidateServiceImplementation();
		return instance;
	}
	
	private final CandidateRepository candidateRepository = new CandidateRepositoryImplementation();
	@Override public CandidateResponse registerNewCandidateCandidate(CandidateRequest candidateRequest) {
		return CandidateMapper.map(candidateRepository.saveCandidate(CandidateMapper.map(candidateRequest)));
	}
	
	@Override public CandidateResponse updateCandidate(CandidateUpdateRequest candidateUpdateRequest) throws RequestNotFoundException {
		Candidate foundCandidate = candidateRepository.findCandidateByName(candidateUpdateRequest.getCandidateFormerName());
		if (candidateUpdateRequest.getCandidateName() != null) foundCandidate.setCandidateName(candidateUpdateRequest.getCandidateName());
		if (candidateUpdateRequest.getPartyName() != null) foundCandidate.setPartyName(candidateUpdateRequest.getPartyName());
		if (candidateUpdateRequest.getElectionId() != null) foundCandidate.setElectionId(candidateUpdateRequest.getElectionId());
		if (candidateUpdateRequest.getElectionId() == null && candidateUpdateRequest.getCandidateName() == null && candidateUpdateRequest.getPartyName() == null)
			throw new RequestNotFoundException("ERROR: you didn't input any field");
		return CandidateMapper.map(candidateRepository.saveCandidate(foundCandidate));
	}
	
	@Override public CandidateResponse updateCandidate(Candidate candidate) {
		return CandidateMapper.map(candidateRepository.saveCandidate(candidate));
	}
	
	@Override
	public CandidateResponse findCandidateBy(String candidateId) {
		return CandidateMapper.map(candidateRepository.findCandidateBy(candidateId));
	}
	
	@Override
	public CandidateResponse findCandidateByName(String candidateName) {
		return CandidateMapper.map(candidateRepository.findCandidateByName(candidateName));
	}
	
	@Override
	public List<CandidateResponse> getCandidatesByElectionId(String electionId) {
		List<CandidateResponse> returnedResponseOfAllCandidatesInAnElection = new ArrayList<>();
		for (int i = 0; i < getAllCandidatesInTheDatabase().size(); i++) {
			if (Objects.equals(candidateRepository.getAllCandidatesInTheDatabase().get(i).getElectionId(), electionId))
				returnedResponseOfAllCandidatesInAnElection.add(CandidateMapper.map(candidateRepository.getAllCandidatesInTheDatabase().get(i)));
		}
		return returnedResponseOfAllCandidatesInAnElection;
	}
	
	@Override
	public List<CandidateResponse> getAllCandidatesInTheDatabase() {
		List<CandidateResponse> responses = new ArrayList<>();
		for (int i = 0; i < candidateRepository.getAllCandidatesInTheDatabase().size(); i++) {
			if (candidateRepository.getAllCandidatesInTheDatabase().get(i) != null)
				responses.add(CandidateMapper.map(candidateRepository.getAllCandidatesInTheDatabase().get(i)));
		}
		return responses;
	}
	
	@Override
	public String deleteCandidateBy(String candidateId) throws RequestNotFoundException {
		boolean isDeleted = candidateRepository.deleteCandidateBy(candidateId);
		if (isDeleted)
			return "Successfully Deleted";
		throw new RequestNotFoundException("Incorrect Id");
	}
	
	@Override
	public String deleteCandidateByCandidateName(String candidateName) throws RequestNotFoundException {
		boolean isDeleted = candidateRepository.deleteCandidateByCandidateName(candidateName);
		if (isDeleted)
			return "Successfully Deleted";
		throw new RequestNotFoundException("Incorrect name");
	}
	
	@Override
	public Candidate getCandidateByPartyName(String partyName) {
		return candidateRepository.getCandidateByPartyName(partyName);
	}
}
