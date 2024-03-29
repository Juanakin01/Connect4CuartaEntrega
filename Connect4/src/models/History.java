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
        this.currentColor = Color.NULL;
    }

    public LinkedList<Coordinate> getList(){
        return this.history;
    }

    public int getIndexHistory(){
        return this.indexHistory;
    }

    public void resetHistory(){
        this.indexHistory = 0;
        this.history.clear();
    }

    public void setColor(Color color){
        this.currentColor = color;
    }

    void updateHistory(Coordinate lastToken){
        this.currentToken = lastToken;
        this.history.add(this.indexHistory++, lastToken);
    }

    private void changeColor(){
        if(this.currentColor == Color.X){
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
        board.setColors(this.currentToken, Color.NULL);
        this.changeColor();
    }

    public void redo(Board board){
        if(indexHistory >= history.size()){
            throw new IndexOutOfBoundsException(utils.Error.NO_REDO_OPTION.getMessage());
        }
        this.currentToken = this.history.get(this.indexHistory++);
        board.setColors(this.currentToken, this.currentColor);
        this.changeColor();
        }
}