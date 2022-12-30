package menugamemode;

import java.util.ArrayList;
import java.util.List;

import models.Connect4;
import views.UtilMenuView;

public abstract class Menu {
    private String title;
    private List<Option> options;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<Option>();
    }

    public void interact(Connect4 connect4) {
        this.interact_(connect4);
    }

    public abstract void addOptions();

    protected void interact_(Connect4 connect4) {
        this.showTitles();
        this.execChooseOption(connect4);
    }

    protected void showTitles() {
        this.showTitle();
        UtilMenuView.write("\nGame modes list:\n");
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

    protected void execChooseOption(Connect4 connect4) {
        int answer;
        boolean ok;
        do {
            answer = UtilMenuView.getInt("Choose option (1-" + this.options.size() + "): ") - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                UtilMenuView.write("Error!!!");
            }
        } while (!ok);
        this.options.get(answer).interact(connect4);
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