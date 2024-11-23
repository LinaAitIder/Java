package Assignment2020.Devoir_2020;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class Commercial {
	private String matricule;
	private String nom;
	private String prenom;
	Set<Product> ProductList;
	
	Commercial(){
		ProductList=new HashSet<Product>();
	}
	
	public Commercial(String string, String string2, String string3) {
		this.matricule  = string;
		this.nom = string2;
		this.prenom= string3;
	}
}
