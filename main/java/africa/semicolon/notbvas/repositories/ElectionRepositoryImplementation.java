package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Election;

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
	public Election save(Election address) {
		return null;
	}
	
	@Override
	public void deleteById(String id) {
		Election foundElection = findById(id);
		if (foundElection.getId() != null) listOfElections.remove(foundElection);
	}
	
	@Override
	public int getCountOfAllElections() {
		return 0;
	}
}
