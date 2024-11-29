package Assignment2020.Devoir_2020;

import java.util.Set;


public class App {
    public static void main(String[] args) {
    	
    	// Displaying the list of Commercials ✅
    	CommercialDaoImpl request = new CommercialDaoImpl();
    	Set<Commercial> Commercials = request.selectAll();
    	for (Commercial com : Commercials) {
    		System.out.println(com.getMatricule());
    		System.out.println(com.getNom());
    		System.out.println(com.getPrenom());
    		System.out.println("---------------------------");
    		
    	}
    	
    	// Deleting the commercial with a specofic matricule ✅
    	String matricule = "MN9489";
    	CommercialDaoImpl deleteReq = new CommercialDaoImpl();
    	deleteReq.delete(matricule);
    	
    	// Adding A product ✅
    	Commercial commercial = new Commercial("MK9383","Mariam","Hamer");

    	// Display A message if the product Already Exists ✅
    	Product product = new Product("Desk","High-Quality Desk",900.0,commercial);
    	ProductDaoImpl addReq = new ProductDaoImpl();
    	int addReqResult = addReq.add(product);
    	if(addReqResult == 0) {
    		System.out.println("The new Product wasn't added !");
    	} else if(addReqResult > 0) {
    		System.out.print("The new Product was succesfully added!");
    	} else {
    		System.out.println("The product Already Exists");
    	}
    	
    	// Updating A product ✅
    	product.setNom("Printer");
    	product.setDescription("Hp Printer");
    	ProductDaoImpl updateReq = new ProductDaoImpl();
    	int updateReqResult = updateReq.update(product);
    	if(updateReqResult > 0) {
    		System.out.println("Product Updated !");
    	}
    	else {
    		System.out.println("Product not Updated!");
    	}
    	
    	// Check if a product Exists ✅
    	ProductDaoImpl checkReq = new ProductDaoImpl();
    	boolean PrdExists = checkReq.ProductExists(product);
    	if (PrdExists) { System.out.println("The product Already Exists");}
    	else {
    		System.out.println(" The product doesn't exist in database ");
    	}
    	
    	// Lunching AWT Frame ✅
    	AddProduct intf = new AddProduct();
    	intf.lunchFrame();
    	
    }
}
