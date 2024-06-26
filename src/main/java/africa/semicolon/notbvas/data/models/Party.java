package africa.semicolon.notbvas.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Party {
	private String id;
	private String partyName;
	private UserInformation userInformation;
}
