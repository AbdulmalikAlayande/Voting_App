package africa.semicolon.notbvas.models;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Address {
	private String id;
	private String houseNumber;
	private String street;
	private String town;
	private String localGovernmentArea;
	private String state;
}
