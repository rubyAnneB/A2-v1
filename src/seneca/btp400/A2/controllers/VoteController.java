package seneca.btp400.A2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seneca.btp400.A2.dao.dbAccessObj;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-20
 * @version 1.0
 *Generates radiobuttons for each candidate and put them on screen. Takes in user input
 * for their vote.
 */

public class VoteController implements Initializable {

    /**
     * Associates the ToggleButton with the ID of the candidate
     */
    static class CandidateToggleButton extends RadioButton {
        int ID;
        CandidateToggleButton(ToggleGroup c , String name, int ID){
            this.setText(name);
            this.setToggleGroup(c);
            this.ID=ID;
        }
    }

    @FXML
    ToggleGroup candidateToggleGrp;
    @FXML
    VBox votingChoices;
    @FXML
    Button voteBtn;
    @FXML Label warning;
    ArrayList<CandidateToggleButton> candidates;
    dbAccessObj db;

    //you need to pass this to the next scene to update voted attribute
    int voterID;


    //called from the previous screen to pass information
    public void setVoter(int voterID){
        this.voterID = voterID;
    }

    /**
     * Moves user to the ConfirmVoteScene
     * @param event Click
     * @param candidateID candidate the was voted for
     * @param candidateName name of candidate voted for
     * @throws IOException
     */
    public void changeConfirmVoteScene(ActionEvent event, int candidateID,String candidateName) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/fxml/ConfirmVote.fxml"));
        Parent confirm = loader.load();

        Scene confirmScene= new Scene(confirm);

        //Access controller
        ConfirmVoteController controller = loader.getController();
        controller.initData(voterID,candidateID,candidateName);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(confirmScene);
        window.show();

    }

    /**
     * Checks if one of the candidates has been selected. If true, moves user to the confirmation scene else gives user warning
     * @param event Vote button is clicked
     * @throws IOException
     */
    public void Vote(ActionEvent event) throws IOException {
        CandidateToggleButton cid = (CandidateToggleButton) candidateToggleGrp.getSelectedToggle();
        if(cid!=null){
            changeConfirmVoteScene(event, cid.ID,cid.getText());
        }else{
            warning.setText("Please choose a candidate");
        }
    }

    /**
     * Get Candidates from the database and generates a CandidateToggleButton for them
     * @throws SQLException
     */
    public void getCandidatesS() throws SQLException {
        ResultSet rs = db.getCandidates();

        while(rs.next()){
            String name = rs.getString("fname") + " "+ rs.getString("lname");
            int id = rs.getInt("idCandidate");
            CandidateToggleButton c = new CandidateToggleButton(candidateToggleGrp,name,id);
            candidates.add(c);
        }


    }


    /**
     * Places all generated buttons on the scene
     */
    public void putButtonsonScene(){
        votingChoices.getChildren().addAll(candidates);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        candidates = new ArrayList<>();
        candidateToggleGrp = new ToggleGroup(); //this line gave me so much trouble- ffs actually initialize stuff ruby -R
        try {
            db = new dbAccessObj();
            getCandidatesS();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       putButtonsonScene();



    }
}
