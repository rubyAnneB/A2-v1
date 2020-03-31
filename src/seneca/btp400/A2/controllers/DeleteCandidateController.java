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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Administrator;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeleteCandidateController implements Initializable {


    @FXML
    Button DeleteCandidateBtn;
    @FXML
    Button CancelBtn;
    @FXML
    TextField studentNumTxtfld;
    @FXML
    Label warningLbl;
Administrator admin;
    dbAccessObj db;

    public void setAdmin(Administrator admin) {
    	this.admin = admin;
    }

	@FXML
	private void deleteCandidate(ActionEvent event) throws IOException, SQLException {
		int id = Integer.parseInt(studentNumTxtfld.getText());
		ResultSet rs = db.getStudentData(id);
		warningLbl.setStyle("-fx-text-fill: red");
		// I can potentially redesign this such that deleteCandidate returns bool
		if (rs.next()) {
			rs = db.getCandidateData(id);
			if (rs.next()) {
				db.deleteCandidate(id);
				warningLbl.setStyle("-fx-text-fill: green");
				warningLbl.setText("Candidate deleted");

			} else {
				warningLbl.setText("Candidate doesn't exist");
			}
		} else {
			warningLbl.setText("This student/voter doesn't exist");
		}

    }


    @FXML
    private void CancelDelete (ActionEvent event)throws IOException {
    	FXMLLoader loader = new FXMLLoader();
 		loader.setLocation(getClass().getResource("../resources/fxml/WelcomeAdmin.fxml"));
 		Parent menu = loader.load();

 		Scene welcomeScene = new Scene(menu);

 		// Access controller
 		WelcomeAdmin controller = loader.getController();
 		controller.initData(this.admin);
 		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
 		window.setScene(welcomeScene);
 		window.show();

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