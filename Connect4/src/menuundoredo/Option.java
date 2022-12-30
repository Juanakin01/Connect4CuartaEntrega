package menuundoredo;

import models.Board;
import utils.Console;
import views.UtilMenuView;

public abstract class Option {
    public static Console console = new Console();
    private String title;

    public Option(String title) {
        this.title = title;
    }

    public abstract void interact(Board board);

    public void showTitle(int index) {
        UtilMenuView.writeln(index + ". " + this.getTitle());
    }

    protected String getTitle() {
        return this.title;
    }
}