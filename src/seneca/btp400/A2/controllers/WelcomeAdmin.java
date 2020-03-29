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
public class WelcomeAdmin implements Initializable {
	Administrator admin;
	@FXML
	Button viewCandidates;
	@FXML
	Button addVoterBtn;
	@FXML
	Label welcomeMessageLbl;
	@FXML
	Button logOut;
	
	public void initData(Administrator admin) {
		this.admin = admin;
		welcomeMessageLbl.setText("Welcome, "+ this.admin.getFullName());
	}

	@FXML
	private void logAdminOut (ActionEvent event) throws IOException{
        admin = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/AdminLogin.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }
	
	@FXML
	private void addVoter (ActionEvent event) throws IOException {
		Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/addNewVoter.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
	}
	
	@FXML
	private void getVotingResults (ActionEvent event) throws IOException {
		Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/ViewCandidateResults.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
