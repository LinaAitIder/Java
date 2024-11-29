package application;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Student {
	private String studentId;
	private String name;
	private String lastName;
	private String email;
	
	
}
