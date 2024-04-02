package africa.semicolon.notbvas.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String id;
	private String houseNumber;
	private String street;
	private String town;
	private String localGovernmentArea;
	private String state;
}
