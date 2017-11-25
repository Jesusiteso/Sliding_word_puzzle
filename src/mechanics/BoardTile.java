package mechanics;


import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class BoardTile extends StackPane {

    private int gridposX;
    private int gridposY;
    private char aChar;
    private Label textLabel;
    private Rectangle rectangle;

    private boolean isInitial;
    private boolean isFinal;
    private boolean isEmpty;
    private boolean isWord;

    public BoardTile(char inChar, int inX, int inY){
        //this.textLabel = new Label();

        this.aChar = inChar;
        this.gridposX = inX;
        this.gridposY = inY;

        this.isInitial = (inX == 0 && inY == 0);
        this.isFinal =   (inX == 5 && inY == 5);
        this.isEmpty =   (inX == 1 && inY == 1);
        this.isWord  = false;


        //this.textLabel.setFont(new Font(20.0));
        //this.textLabel.setPrefWidth(60.0);
        //this.textLabel.setPrefHeight(60.0);

        rectangle = new Rectangle(60,60, Color.LIGHTSKYBLUE);
        rectangle.setStroke(Color.BLACK);

        this.getChildren().add(this.rectangle);
        //this.getChildren().add(this.textLabel);
    }

    public int getGridposX(){
        return this.gridposX;
    }
    public int getGridposY(){
        return  this.gridposY;
    }
    public char getaChar(){
        return this.aChar;
    }

    public boolean isInitial() {
        return this.isInitial;
    }
    public boolean isFinal() {
        return this.isFinal;
    }
    public boolean isEmpty() {
        return this.isEmpty;
    }
    public boolean isWord() {
        return this.isWord;
    }

    public void setGridposX(int inGridPosX){
        this.gridposX = inGridPosX;
    }
    public void setGridposY(int inGridPosY){
        this.gridposY = inGridPosY;
    }
    public void setGridPos(int inGridPosX, int inGridPosY){
        this.gridposX = inGridPosX;
        this.gridposY = inGridPosY;
    }

}
