package africa.semicolon.notbvas.repositories;
import africa.semicolon.notbvas.models.Voter;

import java.util.List;
public interface VoterRepository {
	Voter save(Voter voter);
	List<Voter> findAll();
	Voter findById(String id);
	void deleteById(String id);
	int getCountOfAllVoters();
}
