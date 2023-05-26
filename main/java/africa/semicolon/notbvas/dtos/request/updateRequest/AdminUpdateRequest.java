package africa.semicolon.notbvas.dtos.request.updateRequest;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUpdateRequest {
	@Nullable private String name;
	@Nullable private String password;
}
