package africa.semicolon.notbvas.utils.AppUtils;

import africa.semicolon.notbvas.dtos.request.PartyRequest;
import africa.semicolon.notbvas.dtos.request.VoterRequest;
import africa.semicolon.notbvas.dtos.response.PartyResponse;
import africa.semicolon.notbvas.dtos.response.VoterResponse;
import africa.semicolon.notbvas.models.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Mapper {
	private static final int ZERO = BigInteger.ZERO.intValue();
	private static final int EIGHT = BigInteger.valueOf(8).intValue();
	private static final int FIVE = BigInteger.valueOf(5).intValue();
	
	private static final Map<String, String> userInformationJointTable = new HashMap<>();
	
	public static void linkUserToUserInformation(String userId, String userInformationId){
		userInformationJointTable.put(userId, userInformationId);
	}
	
	public static String getLinkedUserInformationId(String userId){
		if (userInformationJointTable.containsKey(userId))
			return userInformationJointTable.get(userId);
		return "YOU ARE A FOOL";
	}
	
	private static String generatedVoterIdentificationNumber(){
		String res = UUID.randomUUID().toString().toUpperCase();
		String result = stripInvalidCharactersFrom(res);
		StringBuilder result1 = new StringBuilder();
		for (int index = ZERO; index < result.length(); index++)
			if (index % FIVE == ZERO) result1.append(" ");
			else result1.append(result.charAt(index));
		
		int startIndex = BigInteger.ZERO.intValue();
		int endIndex = result1.length() - 4;
		return 	result1.substring(startIndex, endIndex);
	}
	
	private static String stripInvalidCharactersFrom(String randomUUid){
		StringBuilder result = new StringBuilder();
		for (int index = EIGHT; index < randomUUid.length(); index++)
			if (randomUUid.charAt(index) != '-') result.append(randomUUid.charAt(index));
		return result.toString();
	}
	public static Voter map(VoterRequest voterRequest) {
		return Voter.builder()
				       .age(voterRequest.getAge())
				       .userInfo(mappedUserInfo(voterRequest))
				       .address(mappedAddress(voterRequest))
				       .gender(Gender.valueOf(voterRequest.getGender().toUpperCase()))
				       .name(voterRequest.getName())
				       .voterIdentificationNumber(generatedVoterIdentificationNumber())
				       .build();
	}
	
	private static UserInformation mappedUserInfo(VoterRequest voterRequest) {
		UserInformation userInformation = new UserInformation();
		
		userInformation.setUserName(voterRequest.getUserName());
		userInformation.setPassword(voterRequest.getPassword());
		return userInformation;
	}
	
	private static Address mappedAddress(VoterRequest voterRequest) {
		return Address.builder()
				       .town(voterRequest.getTown())
				       .state(voterRequest.getState())
				       .street(voterRequest.getStreet())
				       .houseNumber(voterRequest.getHouseNumber())
				       .localGovernmentArea(voterRequest.getLga())
				       .build();
	}
	
	public static VoterResponse map(Voter voter) {
		return VoterResponse.builder()
				       .name(voter.getName())
				       .voterIdentificationNumber(voter.getVoterIdentificationNumber())
				       .message("Registration Successful")
				       .id(voter.getId())
				       .build();
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
