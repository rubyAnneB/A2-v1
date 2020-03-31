package seneca.btp400.A2.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Administrator;

/**
 * @author Daniel Derich
 * @since 2020-03-30
 * @version 1.0
 */
public class AdminChangePassword implements Initializable {
	
	@FXML
	PasswordField oldTyped;
	
	@FXML
	PasswordField newTyped;
	
	@FXML
	PasswordField newConfirmed;
	
	@FXML
	Button submitBtn;
	
	@FXML
	Button backtoMenuBtn;
	
	@FXML
	Label display;
	
	
	dbAccessObj db;
	Administrator admin;
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
	@FXML
	public void cancelPasswordChange(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/WelcomeAdmin.fxml"));
		Parent menu = loader.load();

		Scene voteScene = new Scene(menu);

		// Access controller
		WelcomeAdmin controller = loader.getController();
		controller.initData(admin);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(voteScene);
		window.show();
	}
	
	
	@FXML
	public void submission(ActionEvent event) throws SQLException {
		display.setStyle("-fx-text-fill: red");
		if (oldTyped.getText().equals(admin.getPassword()) == true)
		{
			if (oldTyped.getText().equals(newTyped.getText()) == false)
			{
				if (newTyped.getText().equals(newConfirmed.getText()) == true)
				{
					if (newTyped.getText().length() >= 6)
					{
						display.setStyle("-fx-text-fill: green");
						display.setText("Password changed successfully!");
						admin.setPassword(newTyped.getText());
						db.setNewAdminPassword(admin.getId(), newTyped.getText());
					}
					else
					{
						display.setText("Password length too short!");
					}
				}
				else
				{
					display.setText("New password and confirmation do not match.");
				}
			}
			else 
			{
				display.setText("New Password cannot be the same as your Old Password.");
			}

		} else {
			display.setText("Old Password Incorrect.");
		}
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
