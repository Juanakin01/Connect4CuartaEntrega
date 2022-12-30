package models;

import java.util.InputMismatchException;

import views.UtilMenuView;
import views.Views;

public class PlayerHuman extends Player {



    public PlayerHuman(Color color, Board board) {
        super(color, board);
    }

    public void play() throws InputMismatchException {
        boolean caughtEx;
        do{
            try{
                Coordinate coordinate = new Coordinate(0,UtilMenuView.getInt("Introduce column:"));
                this.board.putToken(coordinate.getPosCol(), this.color);
                caughtEx = false;
            }catch(InputMismatchException exception){
                Views.writeln(exception.getMessage());
                caughtEx = true;
            }
        } while(caughtEx);
    }
}
