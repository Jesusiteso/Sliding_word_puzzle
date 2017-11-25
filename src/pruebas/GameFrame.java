package pruebas;

import java.awt.Toolkit;
import javax.swing.JFrame;

//Crea una ventana
public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Dimensiones de la ventana
	public static final int WIDTH=640;
	public static final int HEIGHT=640;

	public GameFrame(GamePanel gamePanel){ //A�ade el Panel a la ventana
		
		this.setTitle("Sliding word puzzle");
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-WIDTH)/2),
				((int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-HEIGHT)/2));		
		this.setVisible(true);
		this.add(gamePanel);
		
		gamePanel.grabFocus();
		gamePanel.requestFocusInWindow();
	}
	
	
}
