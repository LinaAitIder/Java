package application;

import java.sql.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Database {
	Connection cn;
	Statement st; 
	Database(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
			st=cn.createStatement();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
