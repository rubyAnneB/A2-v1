package seneca.btp400.A2.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;
import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Administrator;

/**
 * @author Daniel Derich
 * @since 2020-03-30
 * @version 1.0
 */
public class DeleteVoterController implements Initializable {
	@FXML
    Button deleteBtn;
    @FXML
    Button cancelBtn;
    @FXML
    TextField stNumField;
    @FXML
    TextField emailField;
    @FXML
    Label errorLabel;
	
	Administrator admin;
	dbAccessObj db;


	@FXML
	Button viewCandidates;
	@FXML
	Button addVoterBtn;
	@FXML
	Button deleteVoterBtn;
	@FXML
	Button changePassword;
	@FXML
	Button logOut;
	@FXML
	Button addCandidatebtn;
	@FXML
	Button deleteCandidatebtn;

	//Navigation
	@FXML
	private void logAdminOutScene(ActionEvent event) throws IOException{
		admin = null;
		Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/AdminLogin.fxml"));
		Scene welcomeScene = new Scene(welcome);

		//get stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(welcomeScene);
		window.show();
	}

	@FXML
	private void addVoterScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/addNewVoter.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene welcomeAdminScene = new Scene(welcomeAdmin);

		AddNewVoterController controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(welcomeAdminScene);
		window.show();
	}
	@FXML
	private void deleteVoterScene (ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/DeleteVoter.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene welcomeAdminScene = new Scene(welcomeAdmin);

		DeleteVoterController controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(welcomeAdminScene);
		window.show();
	}

	@FXML
	private void getVotingResultsScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/ViewCandidateResults.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene welcomeAdminScene = new Scene(welcomeAdmin);

		ViewCandidateResults controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(welcomeAdminScene);
		window.show();
	}

	@FXML
	private void passwordChScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/AdminChangePassword.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene scene = new Scene(welcomeAdmin);

		AdminChangePassword controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	private void addCandidateScene(ActionEvent event) throws IOException{
		//link to addCandidate
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/AddCandidate.fxml"));
		Parent addC = loader.load();
		Scene scene = new Scene(addC);

		AddCandidateController controller = loader.getController();
		controller.initData(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	private void deleteCandidateScene(ActionEvent event)throws IOException{
		//link to deleteCandidate
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/DeleteCandidate.fxml"));
		Parent deleteC = loader.load();
		Scene scene = new Scene(deleteC);

		DeleteCandidateController controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}


	public void setAdmin(Administrator admin) {
    	this.admin = admin;
    }

	
	@FXML
    private void deleteVoter(ActionEvent event) throws IOException, SQLException {
		int id = Integer.parseInt(stNumField.getText());
		ResultSet rs = db.getStudentData(id);
		if (rs.next() == true) {
			db.deleteVoter(id, emailField.getText());
			errorLabel.setStyle("-fx-text-fill: green");
			errorLabel.setText("Voter Deleted Successfully!");
		} else {
			errorLabel.setStyle("-fx-text-fill: red");
			errorLabel.setText("Voter does not exist.");
		}	
	}		
	
	@FXML
    private void cancelDelete (ActionEvent event)throws IOException {
		FXMLLoader loader = new FXMLLoader();
 		loader.setLocation(getClass().getResource("../resources/fxml/WelcomeAdmin.fxml"));
 		Parent menu = loader.load();

 		Scene welcomeScene = new Scene(menu);

 		// Access controller
 		WelcomeAdmin controller = loader.getController();
 		controller.initData(this.admin);
 		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
 		window.setScene(welcomeScene);
 		window.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			db = new dbAccessObj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
