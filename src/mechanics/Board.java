package mechanics;

import java.util.ArrayList;

public class Board {

	private final static int SIZE = 6;

	private BoardTile[][] tablero;
	private ArrayList<String> diccionario= new ArrayList<String>();

	public Board(ArrayList<String> inDiccionario, char[][] charBoard){
		this.diccionario = inDiccionario;

		this.tablero = new BoardTile[SIZE][SIZE];
		for (int i = 0 ; i < SIZE ; i++){
			for(int j = 0 ; j < SIZE ; j++){
				this.tablero[i][j] = new BoardTile(charBoard[i][j] , i, j);
			}
		}
	}

	
	
	public int getSize() {
		return SIZE;
	}
	public BoardTile getTile(int x, int y){
		return this.tablero[x][y];
	}
	public ArrayList<String> getDiccionario() {
		return diccionario;
	}

	private boolean moveUp(int inX, int inY){

		if(inY <= 0){
			return false;
		}
		if(tablero[inX][inY - 1].isFinal()){
			return false;
		}

		BoardTile temptile = null;
		temptile = tablero[inX][inY];
		tablero[inX][inY] = tablero[inX][inY - 1];
		tablero[inX][inY - 1] = temptile;

	    tablero[inX][inY].setGridPos(inX,(inY - 1));
	    tablero[inX][inY - 1].setGridPos(inX,inY);

        return true;

	}
	private boolean moveDown(int inX, int inY){
		if(inY >= 5){
			return false;
		}
		if(tablero[inX][inY + 1].isFinal()){
			return false;
		}

		BoardTile temptile = null;
		temptile = tablero[inX][inY];
		tablero[inX][inY] = tablero[inX][inY + 1];
		tablero[inX][inY + 1] = temptile;

		tablero[inX][inY].setGridPos(inX,(inY + 1));
		tablero[inX][inY + 1].setGridPos(inX,inY);

		return true;
	}
	private boolean moveLeft(int inX, int inY) {

		if(inX <= 0){
			return false;
		}
		if(tablero[inX - 1][inY].isFinal()){
			return false;
		}

		BoardTile temptile = null;
		temptile = tablero[inX][inY];
		tablero[inX][inY] = tablero[inX - 1][inY];
		tablero[inX - 1][inY] = temptile;

		tablero[inX][inY].setGridPos((inX - 1),inY);
		tablero[inX - 1][inY].setGridPos(inX,inY);

		return true;

	}
	private boolean moveRight(int inX, int inY) {

		if(inX >= 0){
			return false;
		}
		if(tablero[inX + 1][inY].isFinal()){
			return false;
		}

		BoardTile temptile = null;
		temptile = tablero[inX][inY];
		tablero[inX][inY] = tablero[inX + 1][inY];
		tablero[inX + 1][inY] = temptile;

		tablero[inX][inY].setGridPos((inX + 1),inY);
		tablero[inX + 1][inY].setGridPos(inX,inY);

		return true;

	}

	public void moveAbsolute(int inX, int inY){

		if(!(moveUp(inX,inY))){
			if(!(moveDown(inX,inY))){
				if(!(moveRight(inX,inY))){
					if(!(moveLeft(inX,inY))){
						System.out.println("No se movera");
					}
				}
			}
		}
	}

	public void printBoard() {

		System.out.println("---------------------------------------------");
		for (int i = 0 ; i < SIZE ; i++){
			for(int j = 0 ; j < SIZE ; j++){
				System.out.print(tablero[i][j].getaChar() + " - ");
			}
			System.out.println(" ");
		}
		System.out.println("---------------------------------------------");

	}
	

	

	
	
}
