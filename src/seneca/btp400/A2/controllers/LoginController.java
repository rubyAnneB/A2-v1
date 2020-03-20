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
    Voter voter;

    @FXML
    private void BackbtnAction(ActionEvent event) throws IOException {
        voter = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/Welcome.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    private void welcomeUserSceneChange (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/fxml/WelcomeUser.fxml"));
        Parent welcomeUser= loader.load();

        Scene welcomeUserScene = new Scene(welcomeUser);

        //access controller to access method to initialize its voter object
        WelcomeUserController controller = loader.getController();
        //TODO:WRite the method to initialize the voter object
        //controller.initData

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeUserScene);
        window.show();

    }

    @FXML //TODO: do more research on user verification
    private void LoginAction(ActionEvent event) throws IOException, SQLException {
        String email = emailTxtfld.getText();

        voter = db.buildVoter(email);

        //Find a way to simplify this I don't like all these nested if statements -R
        if(voter.isValid()){
            if(passwordField.getText().equals(voter.getPassword())){
                if(voter.getVoted()){
                    message.setText("This voter has already voted");
                }else{
                    message.setText("");
                    welcomeUserSceneChange(event);
                }

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
    }
}
