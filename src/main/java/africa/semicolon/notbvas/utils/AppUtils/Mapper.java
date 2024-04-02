package africa.semicolon.notbvas.utils.AppUtils;

import africa.semicolon.notbvas.dtos.request.PartyRequest;
import africa.semicolon.notbvas.dtos.response.PartyResponse;
import africa.semicolon.notbvas.models.Party;
import africa.semicolon.notbvas.models.UserInformation;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
	private static final Map<String, String> userInformationJointTable = new HashMap<>();
	
	public static void linkUserToUserInformation(String userId, String userInformationId){
		userInformationJointTable.put(userId, userInformationId);
	}
	
	public static String getLinkedUserInformationId(String userId){
		if (userInformationJointTable.containsKey(userId))
			return userInformationJointTable.get(userId);
		return "YOU ARE A FOOL";
	}
	
	public static Party map(PartyRequest partyRequest){
		UserInformation userInformation = UserInformation.builder()
				                                  .userName(partyRequest.getPartyUserName())
				                                  .password(partyRequest.getPassword())
				                                  .build();
		return Party.builder()
				       .partyName(partyRequest.getPartyUserName())
				       .userInformation(userInformation)
				       .build();
	}
	
	public static PartyResponse map(Party party){
		return PartyResponse.builder()
				       .id(party.getId())
				       .message("Registration successful")
				       .build();
	}
	
}
