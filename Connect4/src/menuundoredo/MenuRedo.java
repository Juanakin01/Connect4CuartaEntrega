package menuundoredo;

import models.Board;
import views.BoardView;
import views.Views;

public class MenuRedo extends Option {

    public MenuRedo() {
        super("Redo");
    }

    @Override
    public void interact(Board board) {
        try {
            board.getHistory().redo(board);
            BoardView.showBoard(board.getColors());
            Views.writeln(board.getHistory().getList().size() - board.getHistory().getIndexHistory() + " redos left" );
        }catch(IndexOutOfBoundsException ex){
            Views.writeln(ex.getMessage());
        }
    }
}