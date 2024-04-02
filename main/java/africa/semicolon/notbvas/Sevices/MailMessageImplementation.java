package africa.semicolon.notbvas.Sevices;

import africa.semicolon.notbvas.models.Voter;

public class MailMessageImplementation implements MailMessageService {
	
	public static MailMessageService getInstance() {
		return new MailMessageImplementation();
	}
	
	@Override
	public void notifyUsersThatElectionHasStarted(Voter[] voters) {
		Mailer mailer = new Mailer();
		mailer.send(voters);
	}
	
	@Override
	public boolean notifyUserThatElectionHasEnded(Voter[] voters) {
		return false;
	}
	
	@Override
	public String notifyUsersThatTheyHasRegisteredSuccessfully(String userId) {
		return null;
	}
}
