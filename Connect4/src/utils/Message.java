package utils;

import views.UtilMenuView;


public enum Message {
    TITLE("--- CONECT4 ---"),
    HORIZONTAL_LINE("---------------------------------------------------------"),
    CONTINUE("Do you want to continue"),
    VICTORY("Player #player you win!!!!!!");

    private String message;

    Message(String message) {
        this.message = message;
    }


    public void writeln() {
        UtilMenuView.writeln(this.message);
    }

    public void writeWinner(String player) {
        assert this == Message.VICTORY;
        UtilMenuView.writeln(this.message.replaceAll("#player", "" + player));
    }

}