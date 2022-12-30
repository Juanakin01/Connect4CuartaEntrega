package models;

import utils.Message;

public abstract class Player {

    protected Color color;
    protected Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

    public abstract void play();

    public void writeWinner() {
        Message.VICTORY.writeWinner(this.color.name());
    }
}