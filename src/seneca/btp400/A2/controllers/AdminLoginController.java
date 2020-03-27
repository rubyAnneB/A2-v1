package seneca.btp400.A2.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Daniel Derich
 * @since 2020-03-27
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
  TextField emailTxtfld;
  @FXML
  PasswordField passwordField;
  @FXML
  Label displayMessage;
  
  dbAccessObj db;
  Voter voter;
  
  
  
  
  
}
