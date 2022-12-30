package menuundoredo;

import models.Board;
import views.BoardView;
import views.Views;

public class MenuUndo extends Option {

    public MenuUndo() {
        super("Undo");
    }

    @Override
    public void interact(Board board) {
        try {
            board.getHistory().undo(board);
            BoardView.showBoard(board.getColors());
            Views.writeln(board.getHistory().getIndexHistory() + " undos left" );
        }catch(IndexOutOfBoundsException ex) {
            Views.writeln(ex.getMessage());
        }
    }
}