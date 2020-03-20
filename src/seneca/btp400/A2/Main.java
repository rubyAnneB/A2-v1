package seneca.btp400.A2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Voter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Welcome.fxml"));
        primaryStage.setTitle("Assignment 2");
        primaryStage.setScene(new Scene(root));


        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);

    }
}
