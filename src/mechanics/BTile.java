package mechanics;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


public class BTile {

	private int x, y;
	private char caracter;
	private Boolean isInitial, isFinal, isEmpty ,isWord=false;
	private CustomStackPane stackPane;
	private Label textLabel;
	private Rectangle rectangle;
	
	public BTile(char caracter){
		this.caracter=caracter;

		stackPane = new CustomStackPane();
		stackPane.setPrefWidth(60.0);
		stackPane.setPrefHeight(60.0);
		stackPane.setMaxWidth(60.0);
		stackPane.setMaxHeight(60.0);

		textLabel = new Label("" + this.caracter);
		textLabel.setPrefWidth(60);
		textLabel.setPrefHeight(60);
		textLabel.setFont(new Font(30.0));
		textLabel.setAlignment(Pos.CENTER);
		rectangle = new Rectangle(60,60, Color.LIGHTSKYBLUE);
		rectangle.setStroke(Color.BLACK);

		stackPane.getChildren().add(rectangle);
		stackPane.getChildren().add(textLabel);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.stackPane.setX(x);
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.stackPane.setY(y);
		this.y = y;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.textLabel.setText("" + caracter);
		this.caracter = caracter;
	}

	public Boolean getInitial() {
		return isInitial;
	}

	public void setInitial(Boolean initial) {
		isInitial = initial;
	}

	public Boolean getFinal() {
		return isFinal;
	}

	public void setFinal(Boolean aFinal) {
		isFinal = aFinal;
	}

	public Boolean getEmpty() {
		return isEmpty;
	}

	public void setEmpty(Boolean empty) {
		isEmpty = empty;
	}

	public Boolean getWord() {
		return isWord;
	}

	public void setWord(Boolean word) {
		isWord = word;
	}

	public CustomStackPane getStackPane() {
		return stackPane;
	}

	public void setStackPane(CustomStackPane stackPane) {
		this.stackPane = stackPane;
	}

	public Label getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(Label textLabel) {
		this.textLabel = textLabel;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
}
	
