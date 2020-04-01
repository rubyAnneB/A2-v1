package seneca.btp400.A2.controllers;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seneca.btp400.A2.model.Administrator;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Daniel Derich
 * @since 2020-03-30
 * @version 1.0
 */
public class WelcomeAdmin implements Initializable {
	Administrator admin;
	@FXML
	Button viewCandidates;
	@FXML
	Button addVoterBtn;
	@FXML
	Button deleteVoterBtn;
	@FXML
	Button changePassword;
	@FXML
	Label welcomeMessageLbl;

	@FXML
	Button logOut;
	@FXML
	Button addCandidatebtn;
	@FXML
	Button deleteCandidatebtn;
	
	public void initData(Administrator admin) {
		this.admin = admin;

		welcomeMessageLbl.setText("Welcome, "+ this.admin.getFullName());
	}

	@FXML
	private void logAdminOutScene(ActionEvent event) throws IOException{
        admin = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("/fxml/AdminLogin.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }
	
	@FXML
	private void addVoterScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/addNewVoter.fxml"));
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
	private void deleteVoterScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/DeleteVoter.fxml"));
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
		loader.setLocation(getClass().getResource("/fxml/ViewCandidateResults.fxml"));
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
		loader.setLocation(getClass().getResource("/fxml/AdminChangePassword.fxml"));
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
		loader.setLocation(getClass().getResource("/fxml/AddCandidate.fxml"));
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
		loader.setLocation(getClass().getResource("/fxml/DeleteCandidate.fxml"));
		Parent deleteC = loader.load();
		Scene scene = new Scene(deleteC);

		DeleteCandidateController controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
