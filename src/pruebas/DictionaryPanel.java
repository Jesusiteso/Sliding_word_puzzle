package pruebas;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class DictionaryPanel extends JPanel {
    Board board;

    public DictionaryPanel(Board inBoard){
        board = inBoard;

        ArrayList<String> list = inBoard.getDiccionario1();


        this.setRequestFocusEnabled(true);
        this.setLocation(GameFrame.WIDTH,0);
        this.setSize(300, GameFrame.HEIGHT);

        this.setBackground(Color.GREEN);

        this.setLayout(new GridLayout(6, 1));

       for(String temp : list){
           JLabel jLabel = new JLabel("" + temp);
           jLabel.setFont(jLabel.getFont().deriveFont(50.0f));
           this.add(jLabel);
       }


    }
}
