package menuundoredo;

import models.Connect4;
import views.UtilMenuView;

public abstract class Option {
    private String title;

    public Option(String title) {
        this.title = title;
    }

    public abstract void interact(Connect4 connect4);

    public void showTitle(int index) {
        UtilMenuView.writeln(index + ". " + this.getTitle());
    }

    protected String getTitle() {
        return this.title;
    }
}