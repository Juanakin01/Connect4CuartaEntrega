package menuundoredo;


import models.Connect4;

abstract class IterativeMenu extends QuitMenu {
    public IterativeMenu(String title) {
        super(title);
    }

    @Override
    public void interact(Connect4 connect4) {
        do {
            this.removeOptions();
            this.addOptions(connect4.getBoard().getHistory());
            this.interact_(connect4);
        } while (!this.isExecutedQuitOption());
    }
}