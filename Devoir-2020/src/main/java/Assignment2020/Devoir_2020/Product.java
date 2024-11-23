package Assignment2020.Devoir_2020;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

//Creating the Product class
public class Product {
	private int id;
	private String nom;
	private String description;
	private double prix;
	Commercial commercial;
	
	//Creating A constructor that doen't include the id
	public Product(String nom , String description , Double price , Commercial commercial) {
		this.nom = nom;
		this.description = description;
		this.prix = price;
		this.commercial = commercial;
	}
	
	//Redefining the method equals
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) return true;
		
	    if (obj == null || getClass() != obj.getClass()) {
	            return false;
	     }
	    
		Product other = (Product) obj;
	    return (this.id == other.getId());

	}
	
	//Redefining the method hashcode 
	@Override
	public int hashCode() {
		return Objects.hash(id, nom , description , prix , commercial);
		
	}
	
	

}
