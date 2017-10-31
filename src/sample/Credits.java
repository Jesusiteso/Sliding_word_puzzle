package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Credits implements Initializable {

    public Pane creditsPane;
    public Button btnreturn;

    private BorderPane parentPane;
    private ResourceBundle bundle;

    public Credits (BorderPane inPane) {
        this.parentPane = inPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try{
                    String resourcesLocation = "messages.messages";
                    ResourceBundle rb = ResourceBundle.getBundle(resourcesLocation);

                    parentPane.getChildren().clear();

                    Menu inicioMenu = new Menu();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("menu_view.fxml"));
                    loader.setResources(rb);
                    loader.setController(inicioMenu);
                    parentPane.getChildren().add(loader.load());

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        });

    }
}
