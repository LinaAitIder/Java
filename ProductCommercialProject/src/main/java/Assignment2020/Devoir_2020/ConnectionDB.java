package Assignment2020.Devoir_2020;

 import java.sql.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;

 @Data
 @AllArgsConstructor
 
public class ConnectionDB {
	Connection con;
	Statement st;
	ConnectionDB(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
			st=con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}