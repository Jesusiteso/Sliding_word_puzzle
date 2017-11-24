package mechanics;

import java.util.ArrayList;
import mechanics.BTile;

public class Board {

	private int size=6;
	private BTile tablero[][];
	private Boolean isInitial=false, isFinal=false;
	private int blankX, blankY;
	private ArrayList<String> Diccionario1= new ArrayList<String>();

    public Board(char initial, char fin){
        init();

        //Llenando de car�cteres la matriz

        for(int i=0; i<size; i++) {
            for(int e=0; e<size; e++) {
                if(i==0 && e==0) {
                    tablero[e][i].setInitial(true);
                    tablero[e][i].setEmpty(false);
                    tablero[e][i].setCaracter(initial);
                }else if(i==(size-1) && e==(size-1)) {
                    tablero[e][i].setFinal(true);
                    tablero[e][i].setEmpty(false);
                    tablero[e][i].setCaracter(fin);
                }else if(i==1 && e==1) {
                    tablero[e][i].setEmpty(true);
                    blankX=e;
                    blankY=i;
                }else {
                    tablero[e][i].setCaracter('X');
                    tablero[e][i].setEmpty(false);
                    tablero[e][i].setFinal(false);
                    tablero[e][i].setInitial(false);
                }
            }
        }

        fillLevel1();
    }
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BTile getTablero(int x, int y) {
		return this.tablero[x][y];
	}

	public void setTablero(BTile[][] tablero) {
		this.tablero = tablero;
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

	    if(blankY <= 0)
	        return false;
        if(tablero[blankX][blankY-1].getFinal() != false)
            return false;


        BTile tempTile = tablero[blankX][blankY];
        tablero[blankX][blankY] = tablero[blankX][blankY-1];
        tablero[blankX][blankY-1] = tempTile;


        /*
		tablero[blankX][blankY].setCaracter(tablero[blankX][blankY-1].getCaracter());
		tablero[blankX][blankY].setEmpty(false);

		tablero[blankX][blankY-1].setCaracter(' ');
		tablero[blankX][blankY-1].setEmpty(true);
		*/
        blankY--;
        tablero[blankX][blankY].setY( tablero[blankX][blankY].getY() + 1 );
        return true;

	}
	
	public Boolean moveDown(){
        if(blankY >= 5)
            return false;
        if(tablero[blankX][blankY+1].getFinal() != false){
        	System.out.println("Este no es tu dominio");
        	return false;
		}
            //return false;


        BTile tempTiel = tablero[blankX][blankY];
        tablero[blankX][blankY] = tablero[blankX][blankY+1];
        tablero[blankX][blankY+1] = tempTiel;
        /*
		tablero[blankX][blankY].setCaracter(tablero[blankX][blankY+1].getCaracter());
		tablero[blankX][blankY].setEmpty(false);

		tablero[blankX][blankY+1].setCaracter(' ');
		tablero[blankX][blankY+1].setEmpty(true);
		*/
		tablero[blankX][blankY].setY( tablero[blankX][blankY].getY() - 1 );
        blankY++;
        return true;

	}

	public Boolean moveLeft() {

        if(blankX <= 0)
            return false;
        if(tablero[blankX-1][blankY].getFinal() != false)
            return false;

        BTile tempTiel = tablero[blankX][blankY];
        tablero[blankX][blankY] = tablero[blankX-1][blankY];
        tablero[blankX-1][blankY] = tempTiel;
        /*
		tablero[blankX][blankY].setCaracter(tablero[blankX-1][blankY].getCaracter());
		tablero[blankX][blankY].setEmpty(false);

		tablero[blankX-1][blankY].setCaracter(' ');
		tablero[blankX-1][blankY].setEmpty(true);
		*/
		tablero[blankX][blankY].setX( tablero[blankX][blankY].getX() + 1 );
        blankX--;
        return true;

	}
	
	public Boolean moveRight() {
        if(blankX >= 5) {
            System.out.println("sadasd");
            return false;
        }
        if(tablero[blankX+1][blankY].getFinal() != false) {
            System.out.println("flag2");
            return false;
        }

        BTile tempTiel = tablero[blankX][blankY];
        tablero[blankX][blankY] = tablero[blankX+1][blankY];
        tablero[blankX+1][blankY] = tempTiel;
        /*
		tablero[blankX][blankY].setCaracter(tablero[blankX+1][blankY].getCaracter());
		tablero[blankX][blankY].setEmpty(false);

		tablero[blankX+1][blankY].setCaracter(' ');
		tablero[blankX+1][blankY].setEmpty(true);
		*/
		tablero[blankX][blankY].setX( tablero[blankX][blankY].getX() - 1 );
        blankX++;
        return true;

	}

	public boolean moveAbsolute(int x, int y){
		if((blankX == x && blankY == y) || (x == 0 && y == 0) || (x == 5 && y == 5)) {
			return false;
		}

		if((blankX == x && blankY == (y+1))){
			return moveUp();
		} else  if((blankX == x && blankY == (y-1))){
			return moveDown();
		} else if((blankX == (x-1) && blankY == y)){
			return moveRight();
		} else if((blankX == (x+1) && blankY == y)){
			return moveLeft();
		} else {
			return false;
		}
	}

	
	public void initDiccionario1() {
		Diccionario1.add("RUBY");
		Diccionario1.add("ROSE");
		Diccionario1.add("BROOM");
		Diccionario1.add("TANK");
		Diccionario1.add("PHONE");
		Diccionario1.add("WATER");
			
	}
	

	
	public void init(){
		//Toma el tama�o dado y crea una matriz, consecuentemente inicializa un BTile por cada espacio
		
		tablero =new BTile[size][size];
		for(int i=0; i<size; i++) {
			for(int e=0; e<size; e++) {
				tablero[e][i] = new BTile(' ');
				tablero[e][i].setX(e);
				tablero[e][i].setY(i);
			}
		}

	}
	
	public void printBoard() {
		
		for(int i=0; i<size; i++) {
			for(int e=0; e<size; e++) {
				System.out.print(tablero[e][i].getCaracter());
				System.out.print(" - ");
			}
			System.out.println(' ');
		}
		System.out.println();
	}
	
	public void checkLeftWord(){
		
		for(int i=0; i<getSize(); i++) {
			for(int e=0; e<getSize(); e++) {
				
				for(int p=0; p<Diccionario1.size(); p++) {
					for(int q=0; q<Diccionario1.get(p).length(); q++) {
					
						//if()
						
						
					}
				}
				
			}
		}
	}
	
	public void fillLevel1() {
		
		initDiccionario1();
		
		tablero[0][1].setCaracter('B');
		tablero[0][2].setCaracter('A');
		tablero[0][3].setCaracter('N');
		tablero[0][4].setCaracter('R');
		tablero[0][5].setCaracter('R');
		tablero[1][0].setCaracter('U');
		//tablero[1][0].setCaracter('E');
		
		//Debug
		tablero[0][1].setCaracter('O');
		tablero[0][2].setCaracter('S');
		tablero[0][3].setCaracter('E');
		tablero[0][4].setCaracter('R');
		tablero[0][5].setCaracter('R');
		//Debug
		
		tablero[1][2].setCaracter('W');
		tablero[1][3].setCaracter('T');
		tablero[1][4].setCaracter('E');
		tablero[1][5].setCaracter('H');
		tablero[2][0].setCaracter('B');
		//tablero[2][0].setCaracter('T');
		tablero[2][1].setCaracter('P');
		tablero[2][2].setCaracter('A');
		tablero[2][3].setCaracter('O');
		tablero[2][4].setCaracter('R');
		tablero[2][5].setCaracter('E');
		
		tablero[3][0].setCaracter('Y');
		//tablero[3][0].setCaracter('M');
		tablero[3][1].setCaracter('K');
		tablero[3][2].setCaracter('O');
		tablero[3][3].setCaracter('O');
		tablero[3][4].setCaracter('R');
		tablero[3][5].setCaracter('N');
		tablero[4][0].setCaracter('Y');
		tablero[4][1].setCaracter('B');
		tablero[4][2].setCaracter('U');
		tablero[4][3].setCaracter('S');
		tablero[4][4].setCaracter('O');
		tablero[4][5].setCaracter('R');
		tablero[5][0].setCaracter('E');
		tablero[5][1].setCaracter('S');
		tablero[5][2].setCaracter('T');
		tablero[5][3].setCaracter('N');
		tablero[5][4].setCaracter('M');
	}
	
	
}
