package seneca.btp400.A2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Voter;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-18
 * @version 1.0
 * Launches the welcome screen
 */
public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Welcome.fxml"));
        primaryStage.setTitle("Assignment 2");
        primaryStage.setScene(new Scene(root));

        dbAccessObj db = new dbAccessObj();
        db.AddVote(39717);

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);

    }
}
