package seneca.btp400.A2.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import seneca.btp400.A2.dao.dbAccessObj;


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
            System.out.println(this.getToggleGroup());
        }
    }

    @FXML
    ToggleGroup candidateToggleGrp;
    @FXML
    VBox btns;
    @FXML
    Button voteBtn;
    ArrayList<CandidateToggleButton> candidates;
    dbAccessObj db;



    public void Vote(ActionEvent event){
        CandidateToggleButton cid = (CandidateToggleButton) candidateToggleGrp.getSelectedToggle();
        System.out.println(cid.ID);
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
        btns.getChildren().addAll(candidates);
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
