package application;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.io.IOException;


public class ListController {
	private ObservableList<Student> studentList ;
	@FXML
	private Button switchBtn;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private TableColumn<Student,String> email;
	@FXML
    private TableColumn<Student, String> name;
	@FXML
	private TableColumn<Student, String> lastName;
    @FXML
	private TableColumn<Student, String> studentId;
    @FXML
	private TableView<Student> studentListControls;

	@FXML
	public void switchToScene1(ActionEvent event) throws IOException{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("./Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void initialize() {
		StudentDaoImp SDI = new StudentDaoImp();
		studentList = SDI.getAllStudents();
		studentId.setCellValueFactory(new PropertyValueFactory<Student, String>("studentId"));
		name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		lastName.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
		studentListControls.setItems(studentList);

	}


	
}
