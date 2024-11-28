package application;
import javafx.scene.*;
import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;

import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;

//import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class ListController {
	//private Set<Student> studentList ;
	@FXML
	private Button switchBtn;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
//	@FXML
//	private ListView<Student> studentListControls;
	@FXML
	public void switchToScene1(ActionEvent event) throws IOException{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("./Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
//	@FXML 
//	public void initialise() {
//		StudentDaoImp SDI = new StudentDaoImp();
//		studentList = new HashSet<>();
//		studentList = SDI.getAllStudents();
//	}
//	@FXML
//	public void SetStudentList() {
//		ListView<Student> studentListView = new ListView<Student>();
//		studentListView.setItems((ObservableList<Student>) studentList);
//	}
	
	
}
