package pruebas;

import javax.swing.*;

public class Tester {

    public static void main(String[] args){



        String level = "";
        int levelnum = 0;
        level = JOptionPane.showInputDialog(null, "Introduce el número del nivel a jugar");

        levelnum = Integer.parseInt(level);

        System.out.println(levelnum);

        GamePanel gamePanel = new GamePanel(levelnum);

        GameInstance gameInstance = new GameInstance(gamePanel);
        gameInstance.start();

        //Inserta las gui dentro de una ventana
        @SuppressWarnings("unused")
        GameFrame gameFrame = new GameFrame(gamePanel);


/*
        Board board = new Board();
        board.printBoard();
        board.checkForWords();
        //board.moveRight();
        board.printIsWord();



        System.out.println("" + board.callWinCheck());
*/
    }

}
