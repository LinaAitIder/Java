package application;


import javafx.collections.ObservableList;

public interface StudentDao {
	Boolean AddStudent(Student student);
	ObservableList<Student> getAllStudents();
}
