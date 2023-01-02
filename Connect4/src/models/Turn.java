package models;


public class Turn {

    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;

    public Turn(Board board, Player[] players) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset(players);
    }

    public void reset(Player[] players) {
        for(int i=0; i < Turn.NUMBER_PLAYERS; i++){
            this.players[i]=players[i];
        }
        this.activePlayer = 0;
    }

    public void play(){
        this.players[this.activePlayer].play();
        this.updateActivePlayer();
    }

    public void updateActivePlayer(){
        if (!this.board.isConnectFour(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public Color getActiveColor(){
        return this.players[this.activePlayer].getColor();
    };

    public void writeWinner() {
        this.players[this.activePlayer].writeWinner();
    }



}