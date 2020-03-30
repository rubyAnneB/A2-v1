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

    dbAccessObj db;


    @FXML
    private void deleteCandidate(ActionEvent event) throws IOException, SQLException {
        int id = Integer.parseInt(studentNumTxtfld.getText());
        ResultSet rs = db.getStudentData(id);
        //I can potentiall redesign this such that deleteCandidate returns bool
        if(rs.next()){
            rs=db.getCandidateData(id);
            if(rs.next()){
                db.deleteCandidate(id);
                warningLbl.setText("Candidate deleted");

            }else{
                warningLbl.setText("Candidate doesn't exists");
            }
        }else{
            warningLbl.setText("This student/voter doesn't exist");
        }

    }


    @FXML
    private void CancelDelete (ActionEvent event)throws IOException {
        Parent cancel = FXMLLoader.load(getClass().getResource("../resources/fxml/WelcomeAdmin.fxml"));
        Scene cancelScene = new Scene(cancel);

        // get stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(cancelScene);
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
