package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Election;
import africa.semicolon.notbvas.utils.AppUtils.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElectionRepositoryImplementation implements ElectionRepository{
	
	List<Election> listOfElections = new ArrayList<>();
	@Override
	public Election findById(String id) {
		for (Election election : listOfElections)
			if (Objects.equals(election.getId(), id)) return election;
		return null;
	}
	
	@Override
	public List<Election> findAll() {
		return listOfElections;
	}
	
	@Override
	public Election save(Election election) {
		if (electionDoesNotExist(election))
			saveNewElection(election);
		return existingElection(election);
	}
	
	private boolean electionDoesNotExist(Election election) {
		return !listOfElections.contains(election) || election.getId() == null;
	}
	
	private void saveNewElection(Election election) {
		election.setId(generatedId());
		listOfElections.add(election);
	}
	
	private String generatedId() {
		StringBuilder myId = new StringBuilder();
		String firstPart = IdGenerator.getCharacter();
		String secondPart = IdGenerator.getCharacter();
		String added = firstPart+secondPart;
		for (int i = 0; i < added.length(); i++) {
			if (i == 4)
				myId.append("-");
			myId.append(added.charAt(i));
		}
		int electionPosition = getCountOfAllElections() + 1;
		return "Election-"+electionPosition+myId+"#created#";
	}
	
	private Election existingElection(Election election) {
		Election foundElection = findById(election.getId());
		if (foundElection != null)
			return foundElection;
		return null;
	}
	
	@Override
	public boolean deleteById(String id) {
		Election foundElection = findById(id);
		if (foundElection.getId() != null) {
			listOfElections.remove(foundElection);
			return true;
		}
		return false;
	}
	
	@Override
	public int getCountOfAllElections() {
		return 0;
	}
}
