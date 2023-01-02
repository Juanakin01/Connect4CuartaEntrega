package menuundoredo;

import models.History;

public class MenuUndoRedo extends IterativeMenu {
    public MenuUndoRedo(String title) {
        super(title);
    }

    @Override
    public void addOptions(History history) {
            this.add(new MenuUndo(history));
            this.add(new MenuRedo(history));
    }
}