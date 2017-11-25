package pruebas;

import java.util.ArrayList;
import pruebas.*;


//Versi�n optimizada del 24/11/2017	03:08 PM

public class Board {

	private static final int size = 6;

	private Tile[][] Tablero;
	private Boolean isInitial=false, isFinal=false;
	private int blankX, blankY;
	private ArrayList<String> Diccionario1= new ArrayList<String>();
	private char[][] caracteresLV1= new char[][] {
		{'R', 'E', 'T', 'M', 'Y', 'E'},
		{'B', ' ', 'U', 'K', 'B', 'S'},
		{'A', 'W', 'A', 'O', 'U', 'T'},
		{'N', 'T', 'O', 'O', 'S', 'N'},
		{'R', 'E', 'R', 'R', 'O', 'M'},
		{'R', 'H', 'E', 'N', 'R', 'Y'},
	};
	private char[][] caracteresLV2= new char[][] {
			{'C', 'R', 'O', 'C', 'M', 'H'},
			{'T', ' ', 'T', 'N', 'O', 'R'},
			{'M', 'R', 'E', 'H', 'T', 'E'},
			{'O', 'H', 'E', 'A', 'R', 'E'},
			{'T', 'R', 'H', 'M', 'A', 'E'},
			{'N', 'C', 'M', 'O', 'E', 'E'},
	};
	private char[][] caracteresLV3= new char[][] {
			{'R', 'E', 'T', 'M', 'Y', 'E'},
			{'B', ' ', 'P', 'K', 'B', 'S'},
			{'A', 'W', 'A', 'O', 'A', 'T'},
			{'K', 'A', 'N', 'N', 'S', 'N'},
			{'R', 'E', 'R', 'R', 'O', 'M'},
			{'R', 'H', 'E', 'N', 'R', 'Y'},
	};
	private char[][] caracteresTest= new char[][] {
		{'R', 'O', 'S', 'E', 'Y', 'E'},
		{'U', ' ', 'W', 'R', 'B', 'S'},
		{'B', 'R', 'A', 'O', 'M', 'K'},
		{'Y', 'O', 'T', 'S', 'S', 'N'},
		{'P', 'H', 'E', 'E', 'O', 'M'},
		{'R', 'E', 'R', 'U', 'B', 'Y'},
	};
	
	//!! Tablero[Y][X]!!
	
public Board(int choice){
		/*
		Tablero= new Tile[SIZE][SIZE];
		
		//Llenando de car�cteres la matriz
		
		for(int i = 0; i< SIZE; i++) {
			for(int e = 0; e< SIZE; e++) {
				Tablero[i][e]=new Tile(caracteresTest[i][e]);
				Tablero[i][e].setIsEmpty(false);
			}
		}
		Tablero[0][0].setIsInitial(true);
		Tablero[5][5].setIsFinal(true);
		Tablero[1][1].setIsEmpty(true);
		blankX=1;
		blankY=1;
		initDiccionario1();*/

	Tablero= new Tile[size][size];
	//Llenando de carácteres la matriz
	blankX=1;
	blankY=1;
	if(choice==1) {
		for(int i=0; i<size; i++) {
			for(int e=0; e<size; e++) {
				Tablero[i][e]=new Tile(caracteresLV1[i][e]);
				Tablero[i][e].setIsEmpty(false);

			}
		}
		Tablero[0][0].setIsInitial(true);
		Tablero[5][5].setIsFinal(true);
		Tablero[1][1].setIsEmpty(true);
		initDiccionario1();

	}else if(choice==2) {
		for(int i=0; i<size; i++) {
			for(int e=0; e<size; e++) {
				Tablero[i][e]=new Tile(caracteresLV2[i][e]);
				Tablero[i][e].setIsEmpty(false);
			}
		}
		Tablero[0][0].setIsInitial(true);
		Tablero[5][5].setIsFinal(true);
		Tablero[1][1].setIsEmpty(true);
		initDiccionario2();
		//Diccionario1=Diccionario2;

	}else if(choice==3) {
		for(int i=0; i<size; i++) {
			for(int e=0; e<size; e++) {
				Tablero[i][e]=new Tile(caracteresLV3[i][e]);
				Tablero[i][e].setIsEmpty(false);

			}
		}
		Tablero[0][0].setIsInitial(true);
		Tablero[5][5].setIsFinal(true);
		Tablero[1][1].setIsEmpty(true);
		initDiccionario3();
		//Diccionario1=Diccionario3;

	}else {
		for(int i=0; i<size; i++) {
			for(int e=0; e<size; e++) {
				Tablero[i][e]=new Tile(caracteresLV1[i][e]);
				Tablero[i][e].setIsEmpty(false);

			}
		}
		Tablero[0][0].setIsInitial(true);
		Tablero[5][5].setIsFinal(true);
		Tablero[1][1].setIsEmpty(true);
		initDiccionario1();
	}
	}
	
	
	public int getSize() {
		return size;
	}

	public Tile[][] getTablero() {
		return Tablero;
	}

	public void setTablero(Tile[][] tablero) {
		Tablero = tablero;
	}

	public Boolean getIsInitial() {
		return isInitial;
	}

	public void setIsInitial(Boolean isInitial) {
		this.isInitial = isInitial;
	}

	public Boolean getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	public int getBlankX() {
		return blankX;
	}

	public void setBlankX(int blankX) {
		this.blankX = blankX;
	}

	public int getBlankY() {
		return blankY;
	}

	public void setBlankY(int blankY) {
		this.blankY = blankY;
	}

	public ArrayList<String> getDiccionario1() {
		return Diccionario1;
	}

	public void setDiccionario1(ArrayList<String> diccionario1) {
		Diccionario1 = diccionario1;
	}
	
	
	public Boolean moveUp() {
		purgeWords();
		if(blankY!=0 && Tablero[blankY-1][blankX].getIsInitial()==false) {
			
			Tablero[blankY][blankX].setCaracter(Tablero[blankY-1][blankX].getCaracter());
			Tablero[blankY][blankX].setIsEmpty(false);
			
			Tablero[blankY-1][blankX].setCaracter(' ');
			Tablero[blankY-1][blankX].setIsEmpty(true);
			blankY--;
			checkForWords();
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public Boolean moveDown() {
		purgeWords();
		if(blankY!=5 && Tablero[blankY+1][blankX].getIsFinal()==false) {
			
			Tablero[blankY][blankX].setCaracter(Tablero[blankY+1][blankX].getCaracter());
			Tablero[blankY][blankX].setIsEmpty(false);
			
			Tablero[blankY+1][blankX].setCaracter(' ');
			Tablero[blankY+1][blankX].setIsEmpty(true);
			blankY++;
			checkForWords();
			return true;
		}else {
			return false;
		}
	}

	public Boolean moveLeft() {
		purgeWords();
		if(blankX!=0 && Tablero[blankY][blankX-1].getIsInitial()==false) {
			
			Tablero[blankY][blankX].setCaracter(Tablero[blankY][blankX-1].getCaracter());
			Tablero[blankY][blankX].setIsEmpty(false);
			
			Tablero[blankY][blankX-1].setCaracter(' ');
			Tablero[blankY][blankX-1].setIsEmpty(true);
			blankX--;
			checkForWords();
			return true;
		}else {
			return false;
		}
		
	}
	
	public Boolean moveRight() {
		purgeWords();
		if(blankX!=5 && Tablero[blankY][blankX+1].getIsInitial()==false && Tablero[blankY][blankX+1].getIsFinal()==false) {
			
			Tablero[blankY][blankX].setCaracter(Tablero[blankY][blankX+1].getCaracter());
			Tablero[blankY][blankX].setIsEmpty(false);
			
			Tablero[blankY][blankX+1].setCaracter(' ');
			Tablero[blankY][blankX+1].setIsEmpty(true);
			blankX++;
			checkForWords();
			return true;
		}else {
			return false;
		}
		
	}
	
	private void initDiccionario1() {
		Diccionario1.add("RUBY");
		Diccionario1.add("ROSE");
		Diccionario1.add("BROOM");
		Diccionario1.add("TANK");
		Diccionario1.add("HENRY");
		Diccionario1.add("WATER");
			
	}
	private void initDiccionario2() {
		Diccionario1.add("CHROME");
		Diccionario1.add("HOME");
		Diccionario1.add("TRON");
		Diccionario1.add("TEAR");
		Diccionario1.add("TREE");

	}

	private void initDiccionario3() {
		Diccionario1.add("KANNA");
		Diccionario1.add("NAME");
		Diccionario1.add("ACE");
		Diccionario1.add("CAKE");
		Diccionario1.add("FEAR");
		Diccionario1.add("DEAD");

	}
	
	public void printBoard() {
		
		for(int i = 0; i< size; i++) {
			for(int e = 0; e< size; e++) {
				System.out.print(Tablero[i][e].getCaracter());
				System.out.print("	");
			}
			System.out.println();
		}
		System.out.println();
		//System.out.println(Tablero[3][4].getCaracter());
	}
	
public void printIsWord() {
		
		for(int i = 0; i< size; i++) {
			for(int e = 0; e< size; e++) {
				System.out.print(Tablero[i][e].getIsWord());
				System.out.print("	");
				System.out.print(Tablero[i][e].getCaracter());
				System.out.print("	");
			}
			System.out.println();
		}
		System.out.println();
	} 	
	
	private void purgeWords() {
		for(int i = 0; i< size; i++) {
			for(int e = 0; e< size; e++) {
				Tablero[i][e].setIsWord(false);
			}
		}
	}
	
//v Aqu� es el reino de los checkers v//

	private void isWordRight(int j, int x, int y) {
		
		for(int h=0; h<Diccionario1.get(j).length(); h++) {
			Tablero[x-h][y].setIsWord(true);
		}
		
	}
	
	private void checkForWordRight(int index, int X, int Y) {
		Boolean Valido=false;
		
		for(int J=0; J<Diccionario1.get(index).length(); J++) {
			if((X-J)>=0 && Diccionario1.get(index).charAt(J)==Tablero[X-J][Y].getCaracter()) {
				Valido=true;
			}else {
				Valido=false;
				break;
			}
		}
		
		if(Valido==true) {
			//System.out.printf("Coincidence found at (" +X +", " +Y +")");
			isWordRight(index, X, Y);
		}
		
	}
	
	private void isWordLeft(int j, int x, int y) {
		
		for(int h=0; h<Diccionario1.get(j).length(); h++) {
			Tablero[x+h][y].setIsWord(true);
		}
		
	}
	
	private void checkForWordLeft(int index, int X, int Y) {
		Boolean Valido=false;
		
		for(int J=0; J<Diccionario1.get(index).length(); J++) {
			if((X+J)< size && Diccionario1.get(index).charAt(J)==Tablero[X+J][Y].getCaracter()) {
				Valido=true;
			}else {
				Valido=false;
				break;
			}
		}
		
		if(Valido==true) {
			//System.out.printf("Coincidence found at (" +X +", " +Y +")");
			isWordLeft(index, X, Y);
		}
		
	}

	private void isWordDown(int j, int x, int y) {
		
		for(int h=0; h<Diccionario1.get(j).length(); h++) {
			Tablero[x][y+h].setIsWord(true);
		}
		
	}
	
	private void checkForWordDown(int index, int X, int Y) {
		Boolean Valido=false;
		
		for(int J=0; J<Diccionario1.get(index).length(); J++) {
			if((Y+J)< size && Diccionario1.get(index).charAt(J)==Tablero[X][Y+J].getCaracter()) {
				Valido=true;
			}else {
				Valido=false;
				break;
			}
		}
		
		if(Valido==true) {
			//System.out.printf("Coincidence found at (" +X +", " +Y +")");
			isWordDown(index, X, Y);
		}
		
	}
	
	private void isWordUp(int j, int x, int y) {
		
		for(int h=0; h<Diccionario1.get(j).length(); h++) {
			Tablero[x][y-h].setIsWord(true);
		}
		
	}
	
	private void checkForWordUp(int index, int X, int Y) {
		Boolean Valido=false;
		
		for(int J=0; J<Diccionario1.get(index).length(); J++) {
			if((Y-J)>=0 && Diccionario1.get(index).charAt(J)==Tablero[X][Y-J].getCaracter()) {
				Valido=true;
			}else {
				Valido=false;
				break;
			}
		}
		
		if(Valido==true) {
			System.out.printf("Coincidence found at (" +X +", " +Y +")");
			isWordUp(index, X, Y);
		}
		
	}
	
	public void checkForWords(){
		
		for(int P=0; P<Diccionario1.size(); P++) { //Recorre diccionario
			//System.out.println(Diccionario1.get(P));
			for(int e = 0; e< size; e++) {
				for(int i = 0; i< size; i++) {
					
					if(Tablero[i][e].getCaracter()==Diccionario1.get(P).charAt(0)) {
						checkForWordLeft(P, i, e);
						checkForWordRight(P, i, e);
						checkForWordUp(P, i, e);
						checkForWordDown(P, i, e);
						//System.out.print("O	");
					}else {
						//System.out.print("X	");
					}
					
				}
				//System.out.println();
			}
			
		}
		
		System.out.println();
		
	}
	
	
	public Boolean callWinCheck() {
		
		ArrayList <Scout> lista= new ArrayList<Scout>();
		
		return winCheck(0, 0, lista);
	}
	
	public Boolean winCheck(int posY, int posX, ArrayList <Scout> arr){
		
		Scout neopolitan = new Scout(posY, posX);
		arr.add(neopolitan);
		
		if(posX<5 && Tablero[posY][posX + 1].getIsWord() && !arr.contains(new Scout(posY, posX + 1))){//Checar hacia derecha
			if(Tablero[posY][posX + 1].getIsFinal()) {
				return true;
			}else if(winCheck(posY, posX+1, arr)){
				
				return true;
			}
		}
		
		if(posX>0 && Tablero[posY][posX - 1].getIsWord() && !arr.contains(new Scout(posY, posX - 1))){
			if(Tablero[posY][posX - 1].getIsFinal()) {
				return true;
			}else if(winCheck(posY, posX-1, arr)){
				return true;
			}
		}
		
		if(posY<5 && Tablero[posY + 1][posX].getIsWord() && !arr.contains(new Scout(posY + 1, posX))) {
			if(Tablero[posY + 1][posX].getIsFinal()) {
				return true;
			}else if(winCheck(posY+1, posX, arr)){
				return true;
			}
		}
		
		if(posY>0 && Tablero[posY - 1][posX].getIsWord() && !arr.contains(new Scout(posY - 1, posX))) {
			if(Tablero[posY - 1][posX].getIsFinal()) {
				return true;
			}else if(winCheck(posY-1, posX, arr)){
				return winCheck(posY-1, posX, arr);
			}
		}
		
		arr.remove(neopolitan);
		
		return false;
	}

	public char getCharacter(int x, int y){
		return Tablero[x][y].getCaracter();
	}
	
/*	public void winnable(int y, int x, int back) {
		Scout Runner= new Scout(y, x, back);
		int crossroadSize=0;
	
if(Tablero[Runner.y][Runner.x].getIsWord()==true) {//Checar donde empieza
			
		if(Runner.x<5 && Tablero[Runner.y][(Runner.x)+1].getIsWord()==true) {//Move Right
			Runner.x++;
			
		}
	
	
		}

		
	}
	
	*/
}

