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
import javafx.stage.Stage;
import seneca.btp400.A2.dao.dbAccessObj;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-20
 * @version 1.0
 *
 */
public class ConfirmVoteController implements Initializable {

    int voterId;
    int candidateId;
    String candidateName;
    dbAccessObj db;
    @FXML
    Label votedCandidatelbl;
    @FXML Button confirmBtn;
    @FXML
    Button CancelBtn;


    /**
     * Takes in information passed from previous scene
     * @param voterId
     * @param candidateID
     * @param candidateName
     */
    public void initData(int voterId, int candidateID, String candidateName){
        this.voterId =voterId;
        this.candidateId=candidateID;
        this.candidateName = candidateName;

        setVotedCandidatelbl();
    }

    /**
     * sets the label for the confirmVote scene to display selected candidate
     */
    public void setVotedCandidatelbl(){
        votedCandidatelbl.setText(candidateName);
    }

    /**
     * Sets the voter's voted value to true and increments the selected candidate
     * @param event mouse click confirm button
     * @throws SQLException
     * @throws IOException
     */
    public void confirmVote(ActionEvent event) throws SQLException, IOException {
        db.setVotedTrue(voterId);
        db.AddVote(candidateId);
        //move to thank you screen
        changeThankYouScene(event);
    }

    /**
     * Moves user to Thank you scene
     * @param event
     * @throws IOException
     */
    public void changeThankYouScene(ActionEvent event) throws IOException {
        Parent thanks = FXMLLoader.load(getClass().getResource("../resources/fxml/ThankYou.fxml"));
        Scene thanksScene = new Scene(thanks);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(thanksScene);
        window.show();
    }

    /**
     * Moves user back to the welcome scene and cancels vote
     * @param event
     * @throws IOException
     */
    public void cancelVote (ActionEvent event) throws IOException {
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/Welcome.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
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
