package seneca.btp400.A2.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import java.util.ArrayList;
import seneca.btp400.A2.model.Candidate;

import seneca.btp400.A2.dao.dbAccessObj;

public class ViewCandidateResults implements Initializable {
	@FXML
	private TableView<Candidate> table;
	@FXML
	private TableColumn<Candidate, String> fnameCol;
	@FXML
	private TableColumn<Candidate, String> lnameCol;
	@FXML
	private TableColumn<Candidate, Integer> voteCol;

	private ObservableList<Candidate> people = FXCollections.observableArrayList();

	dbAccessObj db;
	Candidate cand;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		table = new TableView<>();
		fnameCol = new TableColumn<Candidate, String>("First Name");		
		fnameCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("fname"));
		lnameCol = new TableColumn<Candidate, String>("Last Name");
		lnameCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("lname"));
		voteCol = new TableColumn<Candidate, Integer>("Total Votes");
		voteCol.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("numberOfVotes"));

		try {
			db = new dbAccessObj();
			getCandidates();
			table.getColumns().addAll(fnameCol, lnameCol, voteCol);
			table.setItems(people);	
		} catch (SQLException e) {
			System.err.println("error" + e);
		}
	}
}
