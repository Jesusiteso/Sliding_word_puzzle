package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;




import java.net.URL;
import java.util.ResourceBundle;

public class PlayablePane implements Initializable {

    public Pane playablePane;
    public Label lblscore;
    public GridPane gridPane;
    public TextArea textArea;

    private int scoreplayer;
    //private Board board;
    private Timeline updater;

    public PlayablePane () {
        //this.board = BoardStore.createBoard("nivel 1");
        // System.out.println(board.toString());
        this.scoreplayer = 100000;
        lblscore.setText(" " + Integer.toString(scoreplayer));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeTextArea();
        //addEvents();
        initializeGridPane();



        //Hilo de actualización
        updater = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (scoreplayer > 0) {
                scoreplayer -= 10;
                //lblscore.setText("" + Integer.toString(scoreplayer));
            }
        }));
        updater.setCycleCount(Timeline.INDEFINITE);
        updater.play();

    }

    private void initializeTextArea() {
        final String[] strtemp = {""};
        //board.getDiccionario().forEach( (cadena) -> strtemp[0] += "" + cadena +"\n");
        textArea.setText(strtemp[0]);
        textArea.setEditable(false);
        textArea.setFont(new Font(20));

    }

    private void addEvents() {
        /*
        EventHandler<MouseEvent> eventMoving = event -> {
            //BoardTile stacktemp = (BoardTile) event.getSource();
            //System.out.println("X: " + stacktemp.getX() + "  Y: " + stacktemp.getY());
            initializeGridPane();
            //board.printBoard();
            //board.moveAbsolute(stacktemp.getGridposX(),stacktemp.getGridposY());
            //System.out.println("widht: " + stacktemp.getWidth() + " height: " + stacktemp.getHeight());

        };

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                //board.getTile(i,j).setOnMouseClicked(eventMoving);

            }
        }*/
    }

    private void initializeGridPane() {
        gridPane.getChildren().clear();
        gridPane.getChildren().clear();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                //gridPane.add(board.getTile(i, j), i, j);
            }
        }
    }

}
