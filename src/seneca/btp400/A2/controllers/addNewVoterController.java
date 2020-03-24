package seneca.btp400.A2.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * displays form for add new voter. Takes info and puts it into the database
 */
public class addNewVoterController  implements Initializable {
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
    private MenuButton campusSelected;   
    
    @FXML
    private Label displayed;
    
    dbAccessObj db;
    Voter voter;

    public void createVoter() throws SQLException {
        
        
        voter = new (0,"","","","",false);
    }
    
    private void SubmitAction(ActionEvent event) throws IOException, SQLException {
        
        
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
