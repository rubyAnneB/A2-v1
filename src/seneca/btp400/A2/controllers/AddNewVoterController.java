package seneca.btp400.A2.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.ResultSet;



import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Administrator;
import seneca.btp400.A2.model.Voter;
/**
 * @author Daniel Derich
 * @since 2020-03-28
 * displays form for add new voter. Takes info and puts it into the database
 */
public class AddNewVoterController  implements Initializable {

    //navigation
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



    @FXML
    private TextField fnameTyped;   
    @FXML
    private TextField lnameTyped; 
    @FXML
    private TextField stnumTyped;
    @FXML
    private TextField emailTyped;
    @FXML
    private PasswordField passTyped;   
    @FXML
    private Label displayed; 

    @FXML
    Button submitBtn;
    @FXML
    Button resetBtn;
    
    dbAccessObj db;
    Voter voter;
    Administrator admin;

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
    private void deleteVoterScene(ActionEvent event) throws IOException {
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
	public boolean createVoter() throws SQLException {
		int studentNumber = Integer.parseInt(stnumTyped.getText());
		ResultSet rs = db.compareVoter(studentNumber, emailTyped.getText()); // checks if student already exists in
																				// database
		
		if (rs.next() == false) {
			voter = new Voter(studentNumber, fnameTyped.getText(), lnameTyped.getText(), emailTyped.getText(), false);
			voter.setPassword(passTyped.getText());
			db.newVoter(studentNumber, fnameTyped.getText(), lnameTyped.getText(), emailTyped.getText(), passTyped.getText());

			ResultSet check = db.compareVoter(studentNumber, emailTyped.getText()); // checks if student inserted properly
			if (check.next() == true) {
				return true;
			} else {
				displayed.setText("Input Invalid!");
				return false;
			}
		} else {
			displayed.setText("Student already registered!");
			return false;
		}
	}
	
    @FXML
    private void SubmitAction(ActionEvent event) throws SQLException {
        
       boolean register = createVoter();

        if (register) {
        	displayed.setStyle("-fx-text-fill: green");
            displayed.setText("Successfully registered!");
        } else {
        	displayed.setStyle("-fx-text-fill: red");
        }
    }

    
    @FXML
    public void clearDisplay() {
        displayed.setText("");
        fnameTyped.setText("");
        lnameTyped.setText("");
        stnumTyped.setText("");
        emailTyped.setText("");
        passTyped.setText("");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            db = new dbAccessObj();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
