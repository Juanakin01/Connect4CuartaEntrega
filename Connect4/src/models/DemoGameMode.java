package models;


public class DemoGameMode implements GameMode {

    public Player[] load(Board board) {
        Player[] players = new PlayerComputer[Turn.NUMBER_PLAYERS];
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            players[i] = new PlayerComputer(Color.get(i), board);
        }
        return players;
    }
}