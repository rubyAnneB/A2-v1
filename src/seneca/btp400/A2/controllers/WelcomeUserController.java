package seneca.btp400.A2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seneca.btp400.A2.model.Voter;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeUserController implements Initializable {

    Voter voter;
    @FXML
    Label welcomeMessageLbl;
    @FXML Label rulesLbl;
    @FXML
    CheckBox agreeChckbx;
    @FXML
    Button continueBtn;
    @FXML Label alertLbl;
    @FXML Button cancelBtn;

    public void initData(Voter voter){
        this.voter= voter;
       welcomeMessageLbl.setText("Welcome, "+ this.voter.getFullName());
       agreeChckbx.setText("I "+this.voter.getFullName()+" have read and understood the above");

    }

    public void  changetoVotingScreen(ActionEvent event) throws IOException {
        if(agreeChckbx.isSelected()){
            Parent vote = FXMLLoader.load(getClass().getResource("../resources/fxml/Vote.fxml"));
            Scene voteScene = new Scene(vote);

            //get stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(voteScene);
            window.show();

        }else{
            alertLbl.setText("Please check the box");
        }
    }

    public void cancelVote (ActionEvent event) throws IOException{
        voter = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/Welcome.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rulesLbl.setText("Before you vote, please read the following: \n" +
                "1. You may only vote once. This means that there are no do overs\n" +
                "2. You are using you own login and are not voting for another individual\n" +
                "3. You are eligible to vote");
    }


}
