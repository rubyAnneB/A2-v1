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
	public BarChart<String,Number> candidateChart;
	@FXML
	public CategoryAxis nameAxis;
	@FXML
	public NumberAxis voteAxis;
	@FXML
	XYChart.Series<String,Number> candidateData;
	dbAccessObj db;
	Administrator admin;


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
			candidateData.getData().add(new XYChart.Data<>(name,rs.getInt("votes")));
		}
		candidateChart.getData().add(candidateData);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		candidateData = new XYChart.Series<>();
		nameAxis.setTickLabelRotation(90);
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
