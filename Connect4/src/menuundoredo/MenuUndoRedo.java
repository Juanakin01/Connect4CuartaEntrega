package menuundoredo;

public class MenuUndoRedo extends IterativeMenu {
    public MenuUndoRedo(String title) {
        super(title);
    }

    @Override
    public void addOptions() {
        this.add(new MenuUndo());
        this.add(new MenuRedo());
    }
}