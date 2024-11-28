package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;



public class MainController {
	@FXML
	private TextField studentName;
	@FXML
	private TextField studentLastName;
	@FXML
	private TextField studentId;
	@FXML
	private TextField email;
	@FXML
	private Button addButton;
	@FXML
	private Label mssg;

	@FXML 
	private Stage stage;
	@FXML 
	private Scene scene;
	@FXML 
	private Parent root;
	@FXML 
	private Button switchBtn;
	
	@FXML
	private void handleAddButtonClick() {
		Student newStudent = new Student(
		studentName.getText(),
		studentLastName.getText(),
		studentId.getText(),
		email.getText()
		);
		//Add To Database
		StudentDaoImp SDI = new StudentDaoImp();
		if(SDI.AddStudent(newStudent)) {
			mssg.setText("The student was added successfully!");
			mssg.setVisible(true);
		} else {
			mssg.setText("Sorry, There was an error , The student was not added!");
			mssg.setVisible(true);
		}
	}
	@FXML 
	private void switchToScene2(ActionEvent event) throws IOException {
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("./list_view.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
