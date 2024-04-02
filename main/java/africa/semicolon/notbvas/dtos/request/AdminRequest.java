package africa.semicolon.notbvas.dtos.request;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AdminRequest {
	private String name;
	private String password;
}
