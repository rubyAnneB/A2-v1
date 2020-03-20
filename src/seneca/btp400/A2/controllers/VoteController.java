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

public class VoteController implements Initializable {

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


    public void setVoter(int voterID){
        this.voterID = voterID;
    }

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
    public void Vote(ActionEvent event) throws IOException {
        CandidateToggleButton cid = (CandidateToggleButton) candidateToggleGrp.getSelectedToggle();
        if(cid!=null){
            System.out.println(cid.ID);
            changeConfirmVoteScene(event, cid.ID,cid.getText());
        }else{
            warning.setText("Please choose a candidate");
        }
    }

    public void getCandidatesS() throws SQLException {
        ResultSet rs = db.getCandidates();

        while(rs.next()){
            String name = rs.getString("fname") + " "+ rs.getString("lname");
            int id = rs.getInt("idCandidate");
            CandidateToggleButton c = new CandidateToggleButton(candidateToggleGrp,name,id);
            candidates.add(c);
        }


    }



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
