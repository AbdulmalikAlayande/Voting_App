package africa.semicolon.notbvas.data.repositories;
import africa.semicolon.notbvas.data.models.Voter;

import java.util.List;
public interface VoterRepository {
	Voter save(Voter voter);
	List<Voter> findAll();
	Voter findById(String id);
	boolean deleteById(String id);
	int getCountOfAllVoters();
	
	Voter getVoterByVoterIdentificationNumber(String vin);
	
	Voter findVoterByVoterUsername(String userName);
}
