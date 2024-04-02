package africa.semicolon.notbvas.utils.AppUtils;

import africa.semicolon.notbvas.dtos.request.VoterCreationRequest;
import africa.semicolon.notbvas.dtos.response.VoterCreationResponse;
import africa.semicolon.notbvas.models.Address;
import africa.semicolon.notbvas.models.Gender;
import africa.semicolon.notbvas.models.UserInformation;
import africa.semicolon.notbvas.models.Voter;

import java.math.BigInteger;
import java.util.UUID;

public class VoterMapper {
	
	private static final int ZERO = BigInteger.ZERO.intValue();
	private static final int EIGHT = BigInteger.valueOf(8).intValue();
	private static final int FIVE = BigInteger.valueOf(5).intValue();
	public static Voter map(VoterCreationRequest voterRequest) {
		return Voter.builder()
				       .age(voterRequest.getAge())
				       .userInfo(mappedUserInfo(voterRequest))
				       .address(mappedAddress(voterRequest))
				       .gender(Gender.valueOf(voterRequest.getGender().toUpperCase()))
				       .name(voterRequest.getName())
				       .email(voterRequest.getEmail())
				       .voterIdentificationNumber(generatedVoterIdentificationNumber())
				       .build();
	}
	
	private static UserInformation mappedUserInfo(VoterCreationRequest voterRequest) {
		UserInformation userInformation = new UserInformation();
		
		userInformation.setUserName(voterRequest.getUserName());
		userInformation.setPassword(voterRequest.getPassword());
		return userInformation;
	}
	
	private static Address mappedAddress(VoterCreationRequest voterRequest) {
		return Address.builder()
				       .town(voterRequest.getTown())
				       .state(voterRequest.getState())
				       .street(voterRequest.getStreet())
				       .houseNumber(voterRequest.getHouseNumber())
				       .localGovernmentArea(voterRequest.getLga())
				       .build();
	}
	
	public static VoterCreationResponse map(Voter voter) {
		return VoterCreationResponse.builder()
				       .name(voter.getName())      
				       .email(voter.getEmail())
				       .voterIdentificationNumber(voter.getVoterIdentificationNumber())
				       .message("Registration Successful")
				       .id(voter.getId())
				       .build();
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
}
