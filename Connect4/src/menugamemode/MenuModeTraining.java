package menugamemode;

import models.Connect4;
import models.TrainingGameMode;

public class MenuModeTraining extends Option {

    public MenuModeTraining() {
        super("Training (player v. machine)");
    }

    @Override
    public void interact(Connect4 connect4) {
        connect4.setGameMode(new TrainingGameMode());
    }
}