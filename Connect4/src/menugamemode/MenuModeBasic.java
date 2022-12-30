package menugamemode;

import models.Connect4;
import models.BasicGameMode;

public class MenuModeBasic extends Option {

    public MenuModeBasic() {
        super("Basic (player v. player)");
    }

    @Override
    public void interact(Connect4 connect4) {
        connect4.setGameMode(new BasicGameMode());
    }
}