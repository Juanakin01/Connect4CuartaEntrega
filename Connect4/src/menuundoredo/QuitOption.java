package menuundoredo;

import models.Connect4;
import views.BoardView;

public class QuitOption extends Option {
    private boolean executed;

    public QuitOption() {
        super("No action");
        this.executed = false;
    }

    @Override
    public void interact(Connect4 connect4) {
        BoardView.showBoard(connect4.getBoard().getColors());
        int toDelete = connect4.getBoard().getHistory().getList().size();
        for(int i=connect4.getBoard().getHistory().getIndexHistory(); i < toDelete; i++){
            connect4.getBoard().getHistory().getList().removeLast();
        }
        this.executed = true;
    }

    protected boolean isExecuted() {
        return this.executed;
    }

    protected void resetQuitOption() {
        this.executed = false;
    }
}