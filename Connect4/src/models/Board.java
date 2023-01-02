package models;

import views.BoardView;

public class Board {

    private Color[][] colors;
    private Coordinate lastToken = new Coordinate(0,0);
    private History history = new History();;
    
    public Board() {
        this.colors = new Color[Coordinate.ROWS][Coordinate.COLS];
        this.reset();
    }

    public void reset() {
        for (int i = 0; i < Coordinate.ROWS; i++) {
            for (int j = 0; j < Coordinate.COLS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void setColors(Coordinate coordinate, Color color) throws IndexOutOfBoundsException {
        if(Coordinate.outOfBounds(coordinate)){
            throw new IndexOutOfBoundsException(utils.Error.OUT_OF_BOUNDS.getMessage());
        }
        this.colors[coordinate.getPosRow()][coordinate.getPosCol()]=color;
    }

    public void putToken(int column, Color color) throws IllegalArgumentException, IndexOutOfBoundsException{
        Coordinate coordinate=new Coordinate(0,column);
        if(!this.isColumnFree(coordinate.getPosCol())){
            throw new IllegalArgumentException(utils.Error.COLUMN_FULL.getMessage());
        }
        while (positionFull(coordinate)){
            coordinate.setRow(coordinate.getPosRow()+1);
        }
        setColors(coordinate,color);
        this.lastToken.setRow(coordinate.getPosRow());
        this.lastToken.setCol(coordinate.getPosCol());
        history.updateHistory(new Coordinate(coordinate.getPosRow(), coordinate.getPosCol()));
        BoardView.showBoard(this.getColors());
    }

    private boolean positionFull(Coordinate coordinate) throws IndexOutOfBoundsException{
        if(Coordinate.outOfBounds(coordinate)){
            throw new IndexOutOfBoundsException(utils.Error.OUT_OF_BOUNDS.getMessage());
        }
        return colors[coordinate.getPosRow()][coordinate.getPosCol()]!= Color.NULL;
    }

    public Color[][] getColors() {
        return colors;
    }

    public Coordinate getLastToken(){
        return this.lastToken;
    }

    public History getHistory(){
        return this.history;
    }

    public boolean isColumnFree(int column){
        if(Coordinate.outOfBounds(new Coordinate(0, column))){
            throw new IndexOutOfBoundsException(utils.Error.OUT_OF_BOUNDS.getMessage());
        }
        return this.colors[Coordinate.ROWS-1][column].isNull();
    }

    public boolean isFull() {
        int acumColumn = 0;
        for(int i = 0; i< Coordinate.COLS; i++){
            if(!isColumnFree(i)){
                acumColumn += 1;
            }
        }
        return acumColumn == Coordinate.COLS;
    };




    public boolean isConnectFour(Color activeColor) {
        return this.isConnectHorizontal(activeColor)
                || this.isConnectVertical(activeColor)
                || this.isConnectDiagonal(activeColor)
                || this.isConnectReverseDiagonal(activeColor);
    }

    private boolean isConnectHorizontal(Color activeColor) {
        int connectTokens = 0;
        Coordinate auxCoordinate = new Coordinate(this.lastToken.getPosRow(), 0);
        while (!Coordinate.outOfBounds(auxCoordinate) && connectTokens < 4) {
            if (colors[auxCoordinate.getPosRow()][auxCoordinate.getPosCol()] == activeColor) {
                connectTokens++;
            } else {
                connectTokens = 0;
            }
            auxCoordinate.setCol(auxCoordinate.getPosCol() + 1);
        }
        return connectTokens == 4;
    }

    private boolean isConnectVertical(Color activeColor) {
        int connectTokens = 0;
        Coordinate auxCoordinate = new Coordinate(0, this.lastToken.getPosCol());
        while (!Coordinate.outOfBounds(auxCoordinate) && connectTokens < 4 && this.positionFull(auxCoordinate) ) {
            if (colors[auxCoordinate.getPosRow()][auxCoordinate.getPosCol()] == activeColor) {
                connectTokens++;
            } else {
                connectTokens = 0;
            }
            auxCoordinate.setRow(auxCoordinate.getPosRow() + 1);
        }
        return connectTokens == 4;
    }

    private boolean isConnectDiagonal(Color activeColor) {
        int connectTokens = 0;
        Coordinate auxCoordinate = this.lastToken;
        while(auxCoordinate.getPosRow()>0 && auxCoordinate.getPosCol()< Coordinate.COLS-1) {
            auxCoordinate.setRow(auxCoordinate.getPosRow()-1);
            auxCoordinate.setCol(auxCoordinate.getPosCol()+1);
        }
        while (!Coordinate.outOfBounds(auxCoordinate) && connectTokens < 4) {
            if (colors[auxCoordinate.getPosRow()][auxCoordinate.getPosCol()] == activeColor) {
                connectTokens++;
            } else {
                connectTokens = 0;
            }
            auxCoordinate.setRow(auxCoordinate.getPosRow() + 1);
            auxCoordinate.setCol(auxCoordinate.getPosCol() - 1);
        }
        return connectTokens == 4;
    }

   private boolean isConnectReverseDiagonal(Color activeColor) {
        int connectTokens = 0;
        Coordinate auxCoordinate = new Coordinate(0, 0);
       while(auxCoordinate.getPosRow()>0 && auxCoordinate.getPosCol()>0) {
           auxCoordinate.setCol(auxCoordinate.getPosCol() - 1);
           auxCoordinate.setRow(auxCoordinate.getPosRow() - 1);
       }
        while (!Coordinate.outOfBounds(auxCoordinate) && connectTokens < 4) {
            if (colors[auxCoordinate.getPosRow()][auxCoordinate.getPosCol()] == activeColor) {
                connectTokens++;
            } else {
                connectTokens = 0;
            }
            auxCoordinate.setRow(auxCoordinate.getPosRow() + 1);
            auxCoordinate.setCol(auxCoordinate.getPosCol() + 1);
        }
        return connectTokens == 4;
    }
}

