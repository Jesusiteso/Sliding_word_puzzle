package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    public BorderPane contentBP;
    public Label lbtitle;
    public Button btnstart, btnoption, btncredits, btnexit;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.bundle = resources;
        lbtitle.setText(bundle.getString("main_title"));
        btnstart.setText(bundle.getString("main_btnstart"));
        btnoption.setText(bundle.getString("main_btnoption"));
        btncredits.setText(bundle.getString("main_btncredits"));
        btnexit.setText(bundle.getString("main_btnexit"));

        String resourcesLocation = "messages.messages";
        ResourceBundle rb = ResourceBundle.getBundle(resourcesLocation);


        btnstart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    contentBP.getChildren().clear();
                    LevelsPane levels = new LevelsPane(contentBP);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("level_view.fxml"));
                    loader.setResources(rb);
                    loader.setController(levels);
                    contentBP.getChildren().add(loader.load());
                }  catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });

        btncredits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try{


                    contentBP.getChildren().clear();
                    Credits creditsController = new Credits(contentBP);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("credits_view.fxml"));
                    loader.setResources(rb);
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
