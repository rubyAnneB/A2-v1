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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Voter;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-19
 * @version 1.0
 *
 * Controller for the login scene. Takes care of the authentication process. And builds the voter object for the
 * voting processs
 */
public class LoginController implements Initializable {

    @FXML Button backBtn;
    @FXML Button LoginBtn;
    @FXML TextField emailTxtfld;
    @FXML PasswordField passwordField;
    @FXML Label message;
    dbAccessObj db;
    Voter voter;

    /**
     * On click, returns to the welcome scene
     * @param event Click
     * @throws IOException
     */
    @FXML
    private void backbtnAction(ActionEvent event) throws IOException {
        voter = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/Welcome.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    /**
     * Moves the user to the welcome user scene
     * @param event
     * @throws IOException
     */
    private void welcomeUserSceneChange (ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/fxml/WelcomeUser.fxml"));
        Parent welcomeUser= loader.load();

        Scene welcomeUserScene = new Scene(welcomeUser);

        //access controller to access method to initialize its voter object-passing info from scene to scene -R
        WelcomeUserController controller = loader.getController();
        controller.initData(voter);
        voter=null;

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeUserScene);
        window.show();

    }

    /**
     * Performs authentication process if passed moves user to the welcomeUser scene
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML //TODO: do more research on user verification
    private void LoginAction(ActionEvent event) throws IOException, SQLException {
        String email = emailTxtfld.getText();

        buildVoter(email);

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

    /**
     * Creates a voter based on the information available for the student with the email
     * @param email student's email
     * @return empty voter if email is invalid else voter constructed from the information retrieved from database
     * @throws SQLException
     */
    public void buildVoter (String email) throws SQLException {
        voter = new Voter();
        ResultSet resultSet = db.getVoterData(email);

        if(resultSet.next()){
            voter.setID(resultSet.getInt("idStudent"));
            voter.setFname(resultSet.getString("fname"));
            voter.setLname(resultSet.getString("lname"));
            voter.setEmail(email);
            voter.setVoted(resultSet.getBoolean("voted"));
            voter.setPassword(resultSet.getString("password"));
        }



    }


    /**
     * Clears the alert, email and password input
     */
    @FXML
    public void clearMessage() {
        message.setText("");
        emailTxtfld.setText("");
        passwordField.setText("");
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
