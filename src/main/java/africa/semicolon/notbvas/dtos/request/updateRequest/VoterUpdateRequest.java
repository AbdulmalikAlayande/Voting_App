package africa.semicolon.notbvas.dtos.request.updateRequest;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoterUpdateRequest {
	@Nullable private String name;
	@Nullable private String password;
	@Nullable private String houseNumber;
	@Nullable private String town;
	@Nullable private String lga;
	@Nullable private String street;
	@Nullable private String state;
	@Nullable private String gender;
	@Nullable private int age;
	@Nullable private String userName;
}
