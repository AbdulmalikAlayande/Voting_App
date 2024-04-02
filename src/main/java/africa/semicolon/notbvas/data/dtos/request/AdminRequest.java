package africa.semicolon.notbvas.data.dtos.request;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AdminRequest {
	private String name;
	private String password;
}
