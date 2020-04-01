package seneca.btp400.A2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-18
 * @version 1.0
 * Launches the welcome screen
 */
public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Welcome.fxml"));
        primaryStage.setTitle("Assignment 2");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }



    public static void main(String[] args) {

        launch(args);

    }
}
