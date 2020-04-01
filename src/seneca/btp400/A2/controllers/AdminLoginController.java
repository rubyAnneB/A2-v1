package seneca.btp400.A2.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Administrator;

/**
 * @author Daniel Derich
 * @since 2020-03-29
 * @version 1.0
 *
 * Controller for administrator login, authentication
 */
public class AdminLoginController implements Initializable {
	@FXML
	Button resetBtn;
	@FXML
	Button backBtn;
	@FXML
	Button submitBtn;
	@FXML
	TextField emailTyped;
	@FXML
	PasswordField passTyped;
	@FXML
	Label displayMessage;
	
	dbAccessObj db;
	Administrator admin;
	
	@FXML
	private void backClick (ActionEvent event) throws IOException{
		admin = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/Welcome.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
	}
	
	
	
	@FXML
	private void loginClick (ActionEvent event) throws IOException, SQLException {
		buildAdministrator(emailTyped.getText());

		displayMessage.setStyle("-fx-text-fill: red");
		
		if(admin.isValid() == true){
            if(passTyped.getText().equals(admin.getPassword()) == true){
            	welcomeAdminSceneChange(event);
            }else {
            	displayMessage.setText("Incorrect password/email");            
            }
		} else {			
			displayMessage.setText("Email not in system");
		}
	}
	
	@FXML
	private void welcomeAdminSceneChange(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/WelcomeAdmin.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene welcomeAdminScene = new Scene(welcomeAdmin);

		WelcomeAdmin controller = loader.getController();
		controller.initData(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(welcomeAdminScene);
		window.show();
	}
	
	private void buildAdministrator (String email) throws SQLException {
		admin = new Administrator();
		ResultSet resultSet = db.getAdmin(email);

        if(resultSet.next()){
            admin.setID(resultSet.getInt("idAdmin"));
            admin.setFname(resultSet.getString("fname"));
            admin.setLname(resultSet.getString("lname"));
            admin.setEmail(email);
            admin.setPassword(resultSet.getString("password"));
        }

	}
	
	
	@FXML
    public void clearMessage() {
        displayMessage.setText("");
        emailTyped.setText("");
        passTyped.setText("");
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
