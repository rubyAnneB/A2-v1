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
        dbAccessObj d= new dbAccessObj();
        System.out.println(d.getVoted(11));
        System.out.println(d.getFullName(0));
        System.out.println(d.getFullName(12659)); //Malia	Jambrozek
        Voter v = d.buildVoter(12659);
        Voter v1 = d.buildVoter("screwe2a@cdbaby89.com");
        System.out.println(v1);
        System.out.println(v);
        primaryStage.show();
    }

    //hello


    public static void main(String[] args) {
        launch(args);

    }
}
