package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.models.Voter;

public interface MailMessageService {
	
	boolean notifyUsersThatElectionHasStarted(Voter[] voters);
	boolean notifyUserThatElectionHasEnded(Voter[] voters);
	String notifyUsersThatTheyHasRegisteredSuccessfully(String userId);
	
}
