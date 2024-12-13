
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Person {
	private int id ;
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	
	Person(){}
}
