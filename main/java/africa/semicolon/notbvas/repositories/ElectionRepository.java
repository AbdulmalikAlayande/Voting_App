package africa.semicolon.notbvas.repositories;

import africa.semicolon.notbvas.models.Election;

import java.util.List;

public interface ElectionRepository {
	Election findById(String id);
	List<Election> findAll();
	Election save(Election election);
	boolean deleteById(String id);
	int getCountOfAllElections();
}
