package models;


public class BasicGameMode implements GameMode {
    public Player[] load(Board board) {
        Player[] players = new PlayerHuman[Turn.NUMBER_PLAYERS];
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            players[i] = new PlayerHuman(Color.get(i), board);
        }
        return players;
    }
}