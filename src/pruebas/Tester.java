package pruebas;

import javax.swing.*;

public class Tester {

    public static void main(String[] args){



        //Ingresa el numero de nivel deseado
        String level = "";
        int levelnum = 0;
        level = JOptionPane.showInputDialog(null, "Introduce el número del nivel a jugar");
        levelnum = Integer.parseInt(level);
        System.out.println(levelnum);

        //Crea un panel para el juego
        GamePanel gamePanel = new GamePanel(levelnum);

        //Crea y corre el hilo principal del juego.
        GameInstance gameInstance = new GameInstance(gamePanel);
        gameInstance.start();

        //Inserta las gui dentro de una ventana
        @SuppressWarnings("unused")
        GameFrame gameFrame = new GameFrame(gamePanel);

    }

}
