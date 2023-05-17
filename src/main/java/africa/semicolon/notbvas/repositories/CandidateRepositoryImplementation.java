package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Candidate;
import africa.semicolon.notbvas.utils.AppUtils.IdGenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CandidateRepositoryImplementation implements CandidateRepository{
	
	private final List<Candidate> listOfCandidates = new ArrayList<>();
	
	@Override
	public Candidate saveCandidate(Candidate candidate) {
		if (candidateDoesNotExist(candidate))
			saveNew(candidate);
		return existing(candidate);
	}
	
	private Candidate existing(Candidate candidate) {
		return findCandidateBy(candidate.getId());
	}
	
	private void saveNew(Candidate candidate) {
		candidate.setId(generatedId());
		listOfCandidates.add(candidate);
	}
	
	private boolean candidateDoesNotExist(Candidate candidate) {
		return !listOfCandidates.contains(candidate) || candidate.getId() == null;
	}
	
	@Override
	public Candidate findCandidateBy(String candidateId) {
		for (Candidate candidate : listOfCandidates)
			if (Objects.equals(candidate.getId(), candidateId)) return candidate;
		return null;
	}
	
	@Override
	public Candidate findCandidateByName(String candidateName) {
		for (Candidate candidate : listOfCandidates)
			if (Objects.equals(candidate.getCandidateName(), candidateName)) return candidate;
		return null;
	}
	
	@Override
	public List<Candidate> getCandidatesByElectionId(String electionId) {
		List<Candidate> allCandidatesInTheElection = new ArrayList<>();
		for (Candidate candidate : listOfCandidates)
			if (Objects.equals(candidate.getElectionId(), electionId)) allCandidatesInTheElection.add(candidate);
		return allCandidatesInTheElection;
	}
	
	@Override
	public List<Candidate> getAllCandidatesInTheDatabase() {
		return listOfCandidates;
	}
	
	@Override
	public boolean deleteCandidateBy(String candidateId) {
		Candidate foundCandidate = findCandidateBy(candidateId);
		if (foundCandidate != null) {
			listOfCandidates.remove(foundCandidate);
			return true;
		}
		return false;
	}
	
	private String generatedId() {
		String character = IdGenerator.getCharacter()+""+IdGenerator.getCharacter()+""+IdGenerator.getCharacter();
		return idFilledWithRandomNumbersAndThe(character).toString();
	}
	
	private StringBuilder idFilledWithRandomNumbersAndThe(String character) {
		StringBuilder id = new StringBuilder();
		for (int i = 0; i < character.length(); i++) {
			if (i % 3 == 0 && i != 0) {
				String number = generateRandomNumbers();
				id.append(number);
				id.append(character.charAt(i));
			}
			id.append(character.charAt(i));
		}
		return id;
	}
	
	private String generateRandomNumbers() {
		SecureRandom secureRandom = new SecureRandom();
		return String.valueOf(secureRandom.nextInt(1));
	}
}
