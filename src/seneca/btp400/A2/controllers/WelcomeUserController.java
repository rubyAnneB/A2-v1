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
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-20
 * Confirms that the user is who they are and informs of the rules related to voting
 * asks for user to check box declaring that they understand the rules before moving to Voting scene
 * gives option to return back to Welcome Page
 */
public class WelcomeUserController implements Initializable {

    Voter voter;
    @FXML Label welcomeMessageLbl;
    @FXML Label rulesLbl;
    @FXML CheckBox agreeChckbx;
    @FXML Button continueBtn;
    @FXML Label alertLbl;
    @FXML Button cancelBtn;

    /**
     * Creates the voter object based on the passed information
     * @param voter the voter to be welcomed
     */
    public void initData(Voter voter){
        this.voter= voter;
       welcomeMessageLbl.setText("Welcome, "+ this.voter.getFullName());
       agreeChckbx.setText("I, "+this.voter.getFullName()+" have read and understood the above");

    }

    /**
     * Moves voter into the voting scene if they have checked the box indicating the have read and understand the rules else
     * alerts user to check the box
     * @param event
     * @throws IOException
     */
    public void changetoVotingScreen(ActionEvent event) throws IOException, SQLException {
        if(agreeChckbx.isSelected()){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../resources/fxml/Vote.fxml"));
            Parent vote = loader.load();

            Scene voteScene= new Scene(vote);

            //Access controller
            VoteController controller = loader.getController();
            controller.setVoter(voter.getId());

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(voteScene);
            window.show();



        }else{
            alertLbl.setText("Please check the box");
        }
    }

    /**
     * Cancels the voting operation and moves the user back to the welcome page
     * @param event
     * @throws IOException
     */
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


    public void clearMessage(ActionEvent event) {
        alertLbl.setText("");
    }
}
