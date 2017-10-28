package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Pane contentPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            contentPane.getChildren().clear();

            Menu inicioMenu = new Menu();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu_view.fxml"));
            loader.setController(inicioMenu);
            contentPane.getChildren().add(loader.load());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
