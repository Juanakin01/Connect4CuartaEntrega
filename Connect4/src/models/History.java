package models;

import java.util.LinkedList;

public class History{

    private int indexHistory;
    private LinkedList<Coordinate> history;
    private Coordinate currentToken;
    private Color currentColor;

    History(){
        this.history = new LinkedList<>();
        this.currentToken = new Coordinate(0,0);
        this.indexHistory = 0;
        this.currentColor = Color.X;
    }

    public LinkedList<Coordinate> getList(){
        return this.history;
    }

    public int getIndexHistory(){
        return this.indexHistory;
    }

    void updateHistory(Coordinate lastToken){
        this.currentToken = lastToken;
        this.history.add(this.indexHistory++, lastToken);
    }

    private void changeColor(){
        if(currentColor == Color.X){
            this.currentColor = Color.O;
        }else{
            this.currentColor = Color.X;
        }
    }

    public void undo(Board board){
        if(indexHistory <= 0){
            throw new IndexOutOfBoundsException(utils.Error.NO_UNDO_OPTION.getMessage());
        }
        this.currentToken = this.history.get(--this.indexHistory);
        this.changeColor();
        board.setColors(this.currentToken, Color.NULL);
    }

    public void redo(Board board){
        if(indexHistory >= history.size()){
            throw new IndexOutOfBoundsException(utils.Error.NO_REDO_OPTION.getMessage());
        }
        this.currentToken = this.history.get(this.indexHistory++);
        this.changeColor();
        board.setColors(this.currentToken, this.currentColor);
    }
}