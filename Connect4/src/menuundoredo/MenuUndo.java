package menuundoredo;

import models.Connect4;
import models.History;
import views.BoardView;
import views.Views;

public class MenuUndo extends Option {

    public MenuUndo(History history) {
        super("Undo " + history.getIndexHistory() + " left" );
    }

    @Override
    public void interact(Connect4 connect4) {
        try {
            connect4.getBoard().getHistory().undo(connect4.getBoard());
            BoardView.showBoard(connect4.getBoard().getColors());
            connect4.getTurn().updateActivePlayer();
        }catch(IndexOutOfBoundsException ex) {
            Views.writeln(ex.getMessage());
        }
    }
}