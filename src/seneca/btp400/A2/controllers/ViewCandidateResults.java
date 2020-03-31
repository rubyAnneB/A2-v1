package seneca.btp400.A2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import seneca.btp400.A2.model.Administrator;
import seneca.btp400.A2.model.Candidate;

import seneca.btp400.A2.dao.dbAccessObj;

/**
 * @author Daniel Derich
 * @since 2020-03-30
 * @version 1.0
 */
public class ViewCandidateResults implements Initializable {
	@FXML
	Button backBtn;
	
	@FXML
	BarChart<String, Number> candidateChart;
	@FXML
	CategoryAxis nameAxis;
	@FXML
	NumberAxis voteAxis;
	
	@FXML
	XYChart.Series series1;
	/*
	@FXML
	private TableView<Candidate> table;
	@FXML
	private TableColumn<Candidate, String> fnameCol;
	@FXML
	private TableColumn<Candidate, String> lnameCol;
	@FXML
	private TableColumn<Candidate, Integer> voteCol;

	private ObservableList<Candidate> people = FXCollections.observableArrayList();
	*/
	dbAccessObj db;
	Candidate cand;
	Administrator admin;
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
	/*
	@FXML
	public void getCandidates() throws SQLException {
		cand = null;
		ResultSet rs = db.getVotingResults();
		while (rs.next()) {
			cand = new Candidate(rs.getInt("idCandidate"), rs.getString("fname"), rs.getString("lname"),
					rs.getString("email"), rs.getBoolean("voted"), rs.getInt("votes"));
			people.add(cand);
			cand = null;
		}
	}
	*/
	
	@FXML void getCandidates() throws SQLException {
		cand = null;
		ResultSet rs = db.getVotingResults();
		while (rs.next()) {
			cand = new Candidate(rs.getInt("idCandidate"), rs.getString("fname"), rs.getString("lname"),
					rs.getString("email"), rs.getBoolean("voted"), rs.getInt("votes"));
			series1.getData().add(new XYChart.Data(cand.getFullName(), cand.getNumberOfVotes()));
			cand = null;
		}
	}
	
	@FXML
	public void backtoMenu(ActionEvent event) throws IOException {
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*
		table = new TableView<>();
		fnameCol = new TableColumn<Candidate, String>("First Name");		
		fnameCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("fname"));
		lnameCol = new TableColumn<Candidate, String>("Last Name");
		lnameCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("lname"));
		voteCol = new TableColumn<Candidate, Integer>("Total Votes");
		voteCol.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("numberOfVotes"));
		*/
		nameAxis = new CategoryAxis();
		voteAxis = new NumberAxis();
		candidateChart = new BarChart<String,Number>(nameAxis, voteAxis);
		candidateChart.setTitle("Current Results");
		nameAxis.setLabel("Candidate");
		voteAxis.setLabel("Number Of Votes");
		series1 = new XYChart.Series();
		series1.setName("Votes");
		
		try {
			db = new dbAccessObj();
			/*getCandidates();
			table.getColumns().addAll(fnameCol, lnameCol, voteCol);
			table.setItems(people);
			*/
			getCandidates();
			candidateChart.getData().add(series1);
		} catch (SQLException e) {
			System.err.println("error" + e);
		}
	}
}
