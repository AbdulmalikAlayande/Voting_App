package africa.semicolon.notbvas.dtos.request.updateRequest;
import com.mongodb.lang.Nullable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoterUpdateRequest {
	@NonNull private String userName;
	@Nullable private String name;
	@Nullable private String email;
	@Nullable private String password;
	@Nullable private String houseNumber;
	@Nullable private String town;
	@Nullable private String lga;
	@Nullable private String street;
	@Nullable private String state;
	@Nullable private String gender;
	@Nullable private int age;
	@Nullable private String newUserName;
}
