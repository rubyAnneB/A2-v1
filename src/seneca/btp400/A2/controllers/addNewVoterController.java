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

    public boolean createVoter() throws SQLException {
        
        ResultSet rs = db.compareVoter(stnumTyped.getInt(), fnameTyped.getText(), lnameTyped.getText(), emailTyped.getText(), passTyped.getText());
        
        if (rs.next() == false) {
            voter = new (stnumTyped.getInt(), fnameTyped.getText(), lnameTyped.getText(), emailTyped.getText(), false);
            voter.setPassword(passTyped.getText());
            ResultSet addResult = db.newVoter(stnumTyped.getInt(), fnameTyped.getText(), lnameTyped.getText(), emailTyped.getText(), passTyped.getText());
            if (addResult.next() == true) {
                return true;
            } else {
                return false;
            }
            
            
        } else { return false; }
        
    }
    
    private void SubmitAction(ActionEvent event) throws IOException, SQLException {
        
       boolean register = createVoter();
        
        if (register) {
            displayed.setText("Successfully registered!");
        }
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
