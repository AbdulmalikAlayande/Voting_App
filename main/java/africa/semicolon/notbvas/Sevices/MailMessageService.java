package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.models.Voter;

public interface MailMessageService {
	
	void notifyUsersThatElectionHasStarted(Voter[] voters);
	boolean notifyUserThatElectionHasEnded(Voter[] voters);
	String notifyUsersThatTheyHasRegisteredSuccessfully(String userId);
	
}
