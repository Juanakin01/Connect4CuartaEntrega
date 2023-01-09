package models;

public class TrainingGameMode implements GameMode {

    public Player[] load(Board board) {
        Player[] players = new Player[Turn.NUMBER_PLAYERS];
        players[0] = new PlayerHuman(Color.get(0), board);
        players[1] = new PlayerComputer(Color.get(1), board);
        return players;
    }
}
