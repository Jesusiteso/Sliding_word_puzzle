package pruebas;
import java.util.ArrayList;

public class Tile {

	private int x, y;
	private char caracter;
	private Boolean isInitial, isFinal, isEmpty ,isWord; 
	
	public Tile(char caracter){
		this.caracter=caracter;
		isInitial=false;
		isFinal=false;
		isEmpty=false;
		isWord=false;
		}
	
	public Boolean getIsWord() {
		return isWord;
	}

	public void setIsWord(Boolean isWord) {
		this.isWord = isWord;
	}
	
	public Boolean getIsInitial() {
		return isInitial;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public Boolean getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	public Boolean getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public void setIsInitial(Boolean isInitial) {
		this.isInitial = isInitial;
	}

	
	
	}
	
