package seneca.btp400.A2.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-19
 * @version 1.0
 * Controller for the Welcome scene. Moves the user to the login scene
 */
public class WelcomeController implements Initializable {

    @FXML
    Button LoginBtn;

    /**
     * Moves the user into the Login scene
     * @param event Click
     * @throws IOException
     */
    @FXML
    private void LoginAction(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("../resources/fxml/Login.fxml"));
        Scene loginScene = new Scene(login);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
