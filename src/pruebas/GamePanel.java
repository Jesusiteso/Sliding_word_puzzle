package pruebas;

import javafx.scene.layout.GridPane;

import java.awt.*;
import javax.swing.*;

//Crea un panel para mover a gumbot y une las estadisticas del juego con el espacio jugable
public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused") //Esto lo puse porque aparece un warning, porque no uso a gumbot directamente
	private ControlTeclas controlTeclas;
	private Board board;
	private JLabel[][] jLabels;

	public GamePanel(int level){
		this.setRequestFocusEnabled(true);
		this.setLocation(300,0);
		this.setSize(640, GameFrame.HEIGHT-30);

		//this.setLayout(null);
		this.setBackground(Color.CYAN);
		this.board = new Board(level);
		jLabels = new JLabel[6][6];


		this.setLayout(new GridLayout(6, 6));
		for (int i = 0; i < 6; i++) {
			for (int n = 0; n < 6; n++) {
				jLabels[i][n] = new JLabel("" + board.getCharacter(i,n));
				//JLabel jLabel =  new JLabel("" + board.getCharacter(i,n));
				jLabels[i][n].setFont (jLabels[i][n].getFont().deriveFont (100.0f));
				this.add(jLabels[i][n]);
				//this.setFont (this.getFont().deriveFont (64.0f));
			}
		}

		/*
		this.add(statsPanel);
		statsPanel.setLocation(0, 0);

		this.add(playPanel);
		playPanel.setLocation(0, StatsPanel.STATS_HEIGHT);*/
		
		
		controlTeclas = new ControlTeclas();
		this.addKeyListener(controlTeclas);

	}

	public Board getBoard() {
		return board;
	}

	/*
	public void addGumBot(GumBot gumbot) {
		this.gumbot = gumbot;
		playPanel.addGumBot(gumbot);
		statsPanel.addGumBot(gumbot);
	}
	
	public void reduceScore(int i){
		this.statsPanel.reduceScore(i);
	}
	
	public void repaintGame(){
		playPanel.repaint();
		statsPanel.repaint();
	}*/

	public void repaintGrid(Board inBoard){
		//System.out.println("repaint - " + inBoard);
		//this.setLayout();
		inBoard.checkForWords();

		this.setLayout(new GridLayout(6, 6));
		for (int i = 0; i < 6; i++) {
			for (int n = 0; n < 6; n++) {
				jLabels[i][n].setText("" + inBoard.getCharacter(i,n));
				jLabels[i][n].setBackground((inBoard.getTablero()[i][n].getIsWord()) ? Color.GREEN : Color.GRAY);
				jLabels[i][n].setOpaque(true);
				//System.out.print("" + inBoard.getCharacter(i,n));
				/*JLabel jLabel =  new JLabel("" + inBoard.getCharacter(i,n));
				jLabel.setFont (jLabel.getFont().deriveFont (100.0f));
				this.add(jLabel);*/
				//this.setFont (this.getFont().deriveFont (64.0f));
			}
		}
	}
}
