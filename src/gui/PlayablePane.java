package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.util.Duration;
import mechanics.*;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayablePane implements Initializable {

    public Pane playablePane;
    public Label lblscore;
    public GridPane gridPane;
    public TextArea textArea;

    private int scoreplayer;
    private Board board;
/*
    final URL resourcemusic = getClass().getResource("resourses/sountrack.mp3");
    final Media media = new Media(resourcemusic.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);*/
    private Timeline updater;

    public PlayablePane () {
        board = new Board('A','B');
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeTextArea();
        initializeGridPane();
/*
        System.out.println(mediaPlayer);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();*/

        scoreplayer = 100000;
        lblscore.setText("" + Integer.toString(scoreplayer));

        updater = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(scoreplayer > 0) {
                    scoreplayer -= 10;
                    lblscore.setText("" + Integer.toString(scoreplayer));
                    //initializeGridPane();

                    /*
                    if(scoreplayer <= 99970) {
                        System.out.println("state: " + board.moveRight());
                    }*/
                }
            }
        }));

        updater.setCycleCount(Timeline.INDEFINITE);
        updater.play();

    }

    private void initializeGridPane() {
        gridPane.getChildren().clear();
        gridPane.getChildren().clear();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                gridPane.add(board.getTablero(i, j).getStackPane(), i, j);
            }
        }
/*
        board.getTablero(1,1).getTextLabel().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Label labelTemp = (Label) event.getSource();

                board.moveDown();
            }
        });*/



    }

    private void initializeTextArea() {
        final String[] strtemp = {""};
        board.getDiccionario1().forEach( (cadena) -> strtemp[0] += "" + cadena +"\n");
        /*
        String fullstr = "";

        for(int i = 0; i < board.getDiccionario1().size() ; i++){
            fullstr += strtemp[i];
        }*/
        textArea.setText(strtemp[0]);
        textArea.setEditable(false);
        textArea.setFont(new Font(20));

        EventHandler<MouseEvent> eventMoving = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CustomStackPane stacktemp = (CustomStackPane) event.getSource();
                System.out.println("X: " + stacktemp.getX() + "  Y: " + stacktemp.getY());
                initializeGridPane();
                System.out.println("move: " + board.moveAbsolute(stacktemp.getX(),stacktemp.getY()));
                System.out.println("widht: " + stacktemp.getWidth() + " height: " + stacktemp.getHeight());
                System.out.println(" " + board.getTablero(stacktemp.getX(),stacktemp.getY()).getCaracter());
            }
        };

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board.getTablero(i,j).getStackPane().setOnMouseClicked(eventMoving);
            }
        }
    }

}
