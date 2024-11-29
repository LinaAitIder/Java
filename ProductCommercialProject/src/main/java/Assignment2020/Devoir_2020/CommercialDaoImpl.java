package Assignment2020.Devoir_2020;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CommercialDaoImpl implements CommercialDao {
	ConnectionDB Db ;
  
	// Creating A list of commercials that exists in DB
	public Set<Commercial> selectAll(){
		Db = new ConnectionDB();
		Set<Commercial> commercls = new HashSet<>(); 
		String req = "Select * from Commercial";
		ResultSet res;
		try {
			res = Db.getSt().executeQuery(req);
			while(res.next()){
				commercls.add(new Commercial(res.getString("matricule"), res.getString("nom"), res.getString("prenom")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Db.close();
		return commercls;
	}
	
	// Deleting a specific Commercial
	public void delete(String matricule) {
		Db = new ConnectionDB();
		String req = "Delete from Commercial Where matricule= ?";
		try {
			PreparedStatement pst=Db.con.prepareStatement(req);
			pst.setString(1, matricule);
			int numberofRowsAffected = pst.executeUpdate();
			if(numberofRowsAffected > 0) {
				System.out.print("The commercial with the matricule :" + matricule +" Was Successfuly Deleted !");
			} else {
				System.out.println("There is no commercial with such matricule");
			}
			
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//getCommercialByMatricule() ...
	public Commercial getCommercialById(String commercialId) {
		Db = new ConnectionDB();
		ResultSet res ;
		Commercial commercial = null;
		String request = "SELECT * FROM Commercial WHERE matricule = ?";
		try {
		PreparedStatement pst = Db.con.prepareStatement(request);
		pst.setString(1, commercialId);
		res = pst.executeQuery();
		if(res.next()) {
			commercial = new Commercial(
					res.getString(1),
					res.getString(2),
					res.getString(3)
			);
		}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return commercial; 
	}
	
	
}
