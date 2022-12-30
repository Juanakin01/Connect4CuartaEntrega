package menuundoredo;

import models.Board;
import views.BoardView;

public class QuitOption extends Option {
    private boolean executed;

    public QuitOption() {
        super("No action");
        this.executed = false;
    }

    @Override
    public void interact(Board board) {
        BoardView.showBoard(board.getColors());
        int toDelete = board.getHistory().getList().size();
        for(int i=board.getHistory().getIndexHistory(); i < toDelete; i++){
            board.getHistory().getList().removeLast();
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