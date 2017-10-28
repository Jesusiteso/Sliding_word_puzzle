package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    public BorderPane contentBP;
    public Button btnstart, btncredits, btnexit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnstart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("btnStart");
            }
        });

        btncredits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try{
                    contentBP.getChildren().clear();
                    Credits creditsController = new Credits(contentBP);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("credits_view.fxml"));
                    loader.setController(creditsController);
                    contentBP.getChildren().add(loader.load());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        });

        btnexit.setOnAction(event -> System.exit(0));

    }
}