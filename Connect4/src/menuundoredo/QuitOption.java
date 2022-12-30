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
        for(int i=board.getHistory().getIndexHistory(); i < board.getHistory().getList().size(); i++){
            board.getHistory().getList().remove(i);
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