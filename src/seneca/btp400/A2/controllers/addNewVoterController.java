package seneca.btp400.A2.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * displays form for add new voter. Takes info and puts it into the database
 */
public class addNewVoterController  implements Initializable {
    @FXML TextField fnameTyped;
    @FXML TextField lnameTyped;
  //@FXML TextField stnumTyped;
    @FXML TextField emailTyped;
    @FXML PasswordField passTyped;
    
    dbAccessObj db;
    Voter voter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            db = new dbAccessObj();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
