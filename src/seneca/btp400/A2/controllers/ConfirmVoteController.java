package seneca.btp400.A2.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmVoteController implements Initializable {

    int voterId;
    int candidateId;


    public void initData(int voterId, int candidateID){
        this.voterId =voterId;
        this.candidateId=candidateID;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
