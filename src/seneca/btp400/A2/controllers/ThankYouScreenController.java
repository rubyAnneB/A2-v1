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
 * @since 2020-03-20
 * @version 1.0
 * The ending scene. Takes user back to the welcome screen
 */
public class ThankYouScreenController implements Initializable {


    @FXML
    Button homebtn;

    /**
     * Moves the user back to the Welcome Screen
     * @param event Home button is clicked
     * @throws IOException
     */

    //TODO:See if there is a way to delay scene so that it automatically changes scenes after set time
    public void changeWelcomeScene (ActionEvent event) throws IOException {
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/Welcome.fxml"));
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
