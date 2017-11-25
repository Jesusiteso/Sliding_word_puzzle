package pruebas;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class GameInstance extends Thread {

    //Delay de hilo
    private static final int MAIN_SLEEP_TIME=200;
    //Define si el juego esta corriendo
    private boolean gameIsRunning;
    //Tablero principal del juego
    private Board board;

    private GamePanel gamePanel;

    public GameInstance(GamePanel gamePanel){
        board = gamePanel.getBoard();
        board.checkForWords();
        gameIsRunning = true;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {

        while (gameIsRunning) {


            //refreshScreen();
            manageKeys();

            try {
                Thread.sleep(MAIN_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(board.callWinCheck()){
                gameIsRunning = false;
                GameInstance.interrupted();
                JOptionPane.showMessageDialog(null, "You Won");
            }

            gamePanel.repaint();
            gamePanel.repaintGrid(this.board);
        }
    }

    private void manageKeys(){
        //Revisa las teclas presionadas
        HashSet<Integer> currentKeys = ControlTeclas.getActiveKeys();

        //System.out.println("" + Arrays.toString(currentKeys.toArray()));
        //System.out.println(KeyEvent.VK_D);

        //Dependiendo la tecla presionada realiza las acciones
        if(currentKeys.contains(KeyEvent.VK_RIGHT)
                || currentKeys.contains(KeyEvent.VK_D)){
            board.moveRight();
            //refreshScreen();
        } else if (currentKeys.contains(KeyEvent.VK_LEFT)
                || currentKeys.contains(KeyEvent.VK_A)){
            board.moveLeft();
            //refreshScreen();
        } else if(currentKeys.contains(KeyEvent.VK_UP)
                || currentKeys.contains(KeyEvent.VK_W)){
            board.moveUp();
            //refreshScreen();
        } else if(currentKeys.contains(KeyEvent.VK_DOWN)
                || currentKeys.contains(KeyEvent.VK_S)){
            board.moveDown();
            //refreshScreen();
        }

    }

    private void refreshScreen(){
        /*
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        board.printBoard();
    }

}
