package seneca.btp400.A2.controllers;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Voter;


public class LoginController implements Initializable {

    @FXML Button backBtn;
    @FXML Button LoginBtn;
    @FXML TextField emailTxtfld;
    @FXML PasswordField passwordField;
    @FXML Label message;
    dbAccessObj db;

    @FXML
    private void BackbtnAction(ActionEvent event) throws IOException {
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/Welcome.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    @FXML //TODO: do more research on user verification
    private void LoginAction(ActionEvent event) throws IOException, SQLException {
        String email = emailTxtfld.getText();

        Voter voter = db.buildVoter(email);

        if(voter.getId() != 0){
            if(passwordField.getText().equals(voter.getPassword())){
                System.out.println("Login Successful");
                message.setText("");
                //switch scenes-pass voter info
            }else{
                message.setText("incorrect password");
            }
        }else{
            message.setText("email not in system");
        }




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new dbAccessObj();
    }

    @FXML
    public void clearMessage() {
        message.setText("");
        emailTxtfld.setText("");
        passwordField.setText("");
        System.out.println("LLLLLLLL");
    }
}
