package menuundoredo;

import java.util.ArrayList;
import java.util.List;

import models.Board;
import views.UtilMenuView;

public abstract class Menu {
    private String title;
    private List<Option> options;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<Option>();
    }

    public void interact(Board board) {
        this.interact_(board);
    }

    public abstract void addOptions();

    protected void interact_(Board board) {
        this.showTitles();
        this.execChooseOption(board);
    }

    protected void showTitles() {
        this.showTitle();
        UtilMenuView.write("\nSelect Action\n");
        for (int i = 0; i < this.options.size(); i++) {
            this.options.get(i).showTitle(i + 1);
        }
        UtilMenuView.writeln();
    }

    private void showTitle() {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        UtilMenuView.write(string);
    }

    protected void execChooseOption(Board board) {
        int answer;
        boolean ok;
        do {
            answer = UtilMenuView.getInt("Choose option (1-" + this.options.size() + "): ") - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                UtilMenuView.write("Error!!!");
            }
        } while (!ok);
        this.options.get(answer).interact(board);
    }

    protected void add(Option option) {
        this.options.add(option);
    }

    protected void removeOptions() {
        this.options.clear();
    }

    protected boolean hasOption(Option option) {
        return this.options.contains(option);
    }
}