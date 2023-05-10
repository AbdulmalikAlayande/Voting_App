package africa.semicolon.notbvas.utils.AppUtils;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
	
	private static final Map<String, String> userInformationJointable = new HashMap<>();
	
	public static void linkUserToUserInformation(String userId, String userInformationId){
		userInformationJointable.put(userId, userInformationId);
	}
	
	public static String getLinkedUserInformationId(String userId){
		if (userInformationJointable.containsKey(userId))
			return userInformationJointable.get(userId);
		return "YOU ARE A FOOL";
	}
	
}
