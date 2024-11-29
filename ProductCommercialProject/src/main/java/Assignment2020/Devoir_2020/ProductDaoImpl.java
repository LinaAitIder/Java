package Assignment2020.Devoir_2020;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductDaoImpl implements ProductDao {
	ConnectionDB db ;
	
	public int getAutoncrementedId(Product p) {
		db = new ConnectionDB();
		int id = 0;
		ResultSet res;
		try {
		String Query = "Select id from product where nom=? AND Price=? and description=? And commercial_id = ?";
		PreparedStatement pst = db.con.prepareStatement(Query);
		pst.setString(1, p.getNom());
		pst.setDouble(2, p.getPrix());
		pst.setString(3, p.getDescription());
		pst.setString(4, p.commercial.getMatricule());
		res = pst.executeQuery();
		if(res.next()) {
			id = res.getInt(1);
			return id;
		}
		}catch(SQLException err){
			err.printStackTrace();
		}
		return id;
	}
	
	public boolean ProductExists(Product p) {
		db = new ConnectionDB();
		ResultSet res;
		try {
		String req = "Select * From product where nom = ? AND Price=? and description=? And commercial_id = ?";
		PreparedStatement pst = db.con.prepareStatement(req);
		pst.setString(1, p.getNom());
		pst.setDouble(2, p.getPrix());
		pst.setString(3, p.getDescription());
		pst.setString(4, p.commercial.getMatricule());
		res = pst.executeQuery();
		if (res.next()) {
			return true;
		}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}
	
	public int add(Product p) {
		db = new ConnectionDB();
		if(ProductExists(p)) {return -1;}
		
		String req = "INSERT INTO product(nom, description, Price, commercial_id) VALUES (?,?, ?, ?);\r\n"
				+ "";
		PreparedStatement pst;
		try {
			pst = db.con.prepareStatement(req);
			pst.setString(1 , p.getNom());
			pst.setString(2 ,p.getDescription());
			pst.setDouble(3 ,p.getPrix());
			pst.setString(4 , p.commercial.getMatricule());
			
			int numberRowsAffected = pst.executeUpdate();
			if(numberRowsAffected > 0) {
				return 1;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//Update Product
	public int update(Product p){
		db = new ConnectionDB();
		try {
			String req = "UPDATE product SET nom = ?, description = ?,"
					+ " Price = ?, commercial_id = ?"
					+ "WHERE id = ?";
			PreparedStatement pst = db.con.prepareStatement(req);
			pst.setInt(5, this.getAutoncrementedId(p));
			pst.setString(1, p.getNom());
			pst.setString(2, p.getDescription());
			pst.setDouble(3, p.getPrix());
			pst.setString(4,p.commercial.getMatricule());
			int numberRowsAffected = pst.executeUpdate();
			if(numberRowsAffected > 0) {
				return 1;
			}
		} catch(SQLException e) {
			e.printStackTrace();;
		}
		return 0;
	}
}
