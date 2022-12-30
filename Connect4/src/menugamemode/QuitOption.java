package menugamemode;

import models.Connect4;

public class QuitOption extends Option {
    private boolean executed;

    public QuitOption() {
        super("Exit");
        this.executed = false;
    }

    @Override
    public void interact(Connect4 connect4) {
        this.executed = true;
    }

    protected boolean isExecuted() {
        return this.executed;
    }
}