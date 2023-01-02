package models;
import views.UtilMenuView;
import views.Views;

public class PlayerHuman extends Player {



    public PlayerHuman(Color color, Board board) {
        super(color, board);
    }

    public void play(){
        boolean caughtEx = true;
        do{
            try{
                Coordinate coordinate = new Coordinate(0,UtilMenuView.getInt("Introduce column:"));
                this.board.putToken(coordinate.getPosCol(), this.color);
                caughtEx = false;
            }catch(IllegalArgumentException exception){
                Views.writeln(exception.getMessage());
            }catch(IndexOutOfBoundsException exception){
                Views.writeln(exception.getMessage());
            }
        } while(caughtEx);
    }
}
