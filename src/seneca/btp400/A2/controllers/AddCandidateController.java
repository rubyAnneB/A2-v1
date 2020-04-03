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
/**
 * @author Ruby Anne Bautista, Daniel Derich
 * @since 2020-03-30
 * @version 1.0
 */
public class AddCandidateController implements Initializable {

    @FXML
    Button AddCandidateBtn;
    @FXML
    Button CancelBtn;
    @FXML
    TextField studentNumTxtfld;
    @FXML
    Label warningLbl;

    Administrator admin;
    dbAccessObj db;

    @FXML
    Button viewCandidates;
    @FXML
    Button addVoterBtn;
    @FXML
    Button deleteVoterBtn;
    @FXML
    Button changePassword;
    @FXML
    Button logOut;
    @FXML
    Button addCandidatebtn;
    @FXML
    Button deleteCandidatebtn;

    //Navigation
    @FXML
    public void logAdminOutScene(ActionEvent event) throws IOException{
        admin = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("/fxml/AdminLogin.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    @FXML
    public void addVoterScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/AddNewVoter.fxml"));
        Parent welcomeAdmin = loader.load();

        Scene welcomeAdminScene = new Scene(welcomeAdmin);

        AddNewVoterController controller = loader.getController();
        controller.setAdmin(admin);
        admin = null;

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeAdminScene);
        window.show();
    }
    @FXML
    public void deleteVoterScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/DeleteVoter.fxml"));
        Parent welcomeAdmin = loader.load();

        Scene welcomeAdminScene = new Scene(welcomeAdmin);

        DeleteVoterController controller = loader.getController();
        controller.setAdmin(admin);
        admin = null;

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeAdminScene);
        window.show();
    }

    @FXML
    public void getVotingResultsScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ViewCandidateResults.fxml"));
        Parent welcomeAdmin = loader.load();

        Scene welcomeAdminScene = new Scene(welcomeAdmin);

        ViewCandidateResults controller = loader.getController();
        controller.setAdmin(admin);
        admin = null;

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeAdminScene);
        window.show();
    }

    @FXML
    public void passwordChScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/AdminChangePassword.fxml"));
        Parent welcomeAdmin = loader.load();

        Scene scene = new Scene(welcomeAdmin);

        AdminChangePassword controller = loader.getController();
        controller.setAdmin(admin);
        admin = null;

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void addCandidateScene(ActionEvent event) throws IOException{
        //link to addCandidate
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/AddCandidate.fxml"));
        Parent addC = loader.load();
        Scene scene = new Scene(addC);

        AddCandidateController controller = loader.getController();
        controller.initData(admin);
        admin = null;

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void deleteCandidateScene(ActionEvent event)throws IOException{
        //link to deleteCandidate
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/DeleteCandidate.fxml"));
        Parent deleteC = loader.load();
        Scene scene = new Scene(deleteC);

        DeleteCandidateController controller = loader.getController();
        controller.setAdmin(admin);
        admin = null;

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

   public void initData(Administrator admin) {
    	this.admin = admin;
    }

    @FXML
    private void addCandidate (ActionEvent event) throws SQLException {
        int id = Integer.parseInt(studentNumTxtfld.getText());
        ResultSet rs = db.getStudentData(id);
        warningLbl.setStyle("-fx-text-fill: red");
        if(rs.next()){
            rs=db.getCandidateData(id);
            if(!rs.next()){
                db.addCandidate(id);
                warningLbl.setStyle("-fx-text-fill: green");
                warningLbl.setText("Candidate added");
            }else{          	
                warningLbl.setText("Candidate already exists");
            }
        }else{
            warningLbl.setText("This student/voter doesn't exist");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            db = new dbAccessObj();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CancelAdd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/WelcomeAdmin.fxml"));
        Parent addC = loader.load();
        Scene scene = new Scene(addC);

        WelcomeAdmin controller = loader.getController();
        controller.initData(admin);
        admin = null;

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
