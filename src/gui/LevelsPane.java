package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LevelsPane implements Initializable {


    public Pane levelPane;

    public Button btnreturn,
            btnlvl1;

    private BorderPane parentPane;


    public LevelsPane (BorderPane inParent) {
        this.parentPane = inParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnlvl1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //String resourcesLocation = "messages.messages";
                    //ResourceBundle rb = ResourceBundle.getBundle(resourcesLocation);

                    PlayablePane playablePane = new PlayablePane();

                    levelPane.getChildren().clear();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("playable_view.fxml"));
                    //loader.setResources(rb);
                    loader.setController(playablePane);
                    levelPane.getChildren().add(loader.load());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });

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
