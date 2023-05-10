package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Address;
import africa.semicolon.notbvas.models.Voter;

import java.util.List;

public interface VoterRepository {
	Voter findById(String id);
	List<Voter> findAll();
	Voter save(Voter voter);
	void deleteById(String id);
	
	int getCountOfAllVoters();
}
