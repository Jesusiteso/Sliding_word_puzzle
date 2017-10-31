package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller mainController = new Controller();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "main_view.fxml"
                )
        );

        loader.setController(mainController);

        primaryStage.setTitle("Sliding word puzzle");
        primaryStage.setScene(new Scene((Parent) loader.load(), 700, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
