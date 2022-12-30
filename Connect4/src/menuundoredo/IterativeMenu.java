package menuundoredo;

import models.Board;

abstract class IterativeMenu extends QuitMenu {
    public IterativeMenu(String title) {
        super(title);
    }

    @Override
    public void interact(Board board) {
        this.removeOptions();
        this.addOptions();
        do {
            this.interact_(board);
        } while (!this.isExecutedQuitOption());
    }
}