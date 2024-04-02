package africa.semicolon.notbvas.data.repositories;
import africa.semicolon.notbvas.data.models.Party;
import java.util.List;

public interface PartyRepository {
	Party findById(String id);
	List<Party> findAll();
	Party save(Party party);
	boolean deleteById(String id);
	int getCountOfAllParties();
	
	Party findPartyByPartyName(String partyName);
}
