package models;

import java.util.Random;


public class PlayerComputer extends Player {

    public PlayerComputer(Color color, Board board) {
        super(color, board);
    }

    public void play() {
        Coordinate coordinate = new Coordinate(0,0);
        Random randomCol = new Random();
        do {
            coordinate.setCol(randomCol.nextInt(7));
        }while(!board.isColumnFree(coordinate.getPosCol()));
        this.board.putToken(coordinate.getPosCol(), this.color);
    }
}
