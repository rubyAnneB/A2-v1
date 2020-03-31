package seneca.btp400.A2.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Administrator;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewCandidateResults implements Initializable {

	@FXML
	public Button backBtn;
	@FXML
	public BarChart<Number,String> candidateChart;
	@FXML
	public CategoryAxis nameAxis;
	@FXML
	public NumberAxis voteAxis;
	@FXML
	XYChart.Series<Number,String> candidateData;
	dbAccessObj db;
	Administrator admin;



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
	private void logAdminOutScene(ActionEvent event) throws IOException{
		admin = null;
		Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/AdminLogin.fxml"));
		Scene welcomeScene = new Scene(welcome);

		//get stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(welcomeScene);
		window.show();
	}

	@FXML
	private void addVoterScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/addNewVoter.fxml"));
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
	private void deleteVoterScene (ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/DeleteVoter.fxml"));
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
	private void getVotingResultsScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/ViewCandidateResults.fxml"));
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
	private void passwordChScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/AdminChangePassword.fxml"));
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
	private void addCandidateScene(ActionEvent event) throws IOException{
		//link to addCandidate
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/AddCandidate.fxml"));
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
	private void deleteCandidateScene(ActionEvent event)throws IOException{
		//link to deleteCandidate
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/DeleteCandidate.fxml"));
		Parent deleteC = loader.load();
		Scene scene = new Scene(deleteC);

		DeleteCandidateController controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}




	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public void backScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/WelcomeAdmin.fxml"));
		Parent menu = loader.load();

		Scene voteScene = new Scene(menu);

		// Access controller
		WelcomeAdmin controller = loader.getController();
		controller.initData(admin);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(voteScene);
		window.show();

	}


	private void getData() throws SQLException {
		candidateData.setName("votes");
		ResultSet rs = db.getCandidates();
		String name;
		while (rs.next()){
			name = rs.getString("fname")+" "+rs.getString("lname");
			candidateData.getData().add(new XYChart.Data<>(rs.getInt("votes"),name));
		}
		candidateChart.getData().add(candidateData);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		candidateData = new XYChart.Series<>();

		try {
			db = new dbAccessObj();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}


}
