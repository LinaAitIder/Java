package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentDaoImp implements StudentDao {
	Database db ;
	@Override
	public Boolean AddStudent(Student student) {
		try {
		db = new Database(); 
		String req="INSERT INTO students values (?,?,?,?)";
		PreparedStatement pst = db.cn.prepareStatement(req);
		pst.setString(1, student.getStudentId());
		pst.setString(2, student.getName());
		pst.setString(3, student.getLastName());
		pst.setString(4, student.getEmail());
		pst.executeUpdate();
		return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ObservableList<Student> getAllStudents(){
		ObservableList<Student> studentList = FXCollections.observableArrayList();			
		try { 
			db = new Database();
			ResultSet res;
			String req = " SELECT * FROM students";
			res = db.getSt().executeQuery(req);
	        while(res.next()){
				studentList.add(new Student(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4)
						));
			} 
		}catch(SQLException e){
			e.printStackTrace();
		}
		return studentList;
	}

	
}
