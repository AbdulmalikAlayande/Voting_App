package africa.semicolon.notbvas.data.dtos.request.updateRequest;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartyUpdateRequest {
	@Nullable  private String password;
	@Nullable private String partyName;
	private String partyFormerName;
	@Nullable  private String partyUserName;
}
