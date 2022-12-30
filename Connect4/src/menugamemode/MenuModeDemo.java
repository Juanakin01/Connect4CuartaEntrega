package menugamemode;

import models.Connect4;
import models.DemoGameMode;

public class MenuModeDemo extends Option {

    public MenuModeDemo() {
        super("Demo (machine v. machine)");
    }

    @Override
    public void interact(Connect4 connect4) {
        connect4.setGameMode(new DemoGameMode());
    }
}