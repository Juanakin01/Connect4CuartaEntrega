package models;

import menugamemode.MenuGameMode;
import menuundoredo.MenuUndoRedo;
import utils.Message;
import views.BoardView;

public class Connect4 {

    private Board board= new Board();
    private Turn turn;
    private GameMode gameMode;
    private MenuGameMode menu = new MenuGameMode("Connect4");
    private MenuUndoRedo menuUR = new MenuUndoRedo("Action?");

    private void play(){
        this.menu.addOptions();
        do{
            this.menu.interact(this);
            if(!this.menu.isExecutedQuitOption()){
                this.turn = new Turn(this.board,gameMode.load(this.board));
                this.board.getHistory().resetHistory();
                this.playGame();
            }
        }while(!this.menu.isExecutedQuitOption() && this.isResumedGame());

    }

    public Board getBoard(){
        return this.board;
    }
    
    public Turn getTurn(){
        return this.turn;
    }
    private void playGame() {
        Message.TITLE.writeln();
        BoardView.showBoard(this.board.getColors());
        do {
            this.turn.play();
            do{
                this.menuUR.interact(this);
            }while(!this.menuUR.isExecutedQuitOption());
            Message.HORIZONTAL_LINE.writeln();
        } while (!board.isFull() && !this.isConnectFour());
        if (this.isConnectFour()) {
            this.turn.writeWinner();
        }
    }

    private boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }

    private boolean isResumedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.CONTINUE.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.reset(gameMode.load(this.board));
        }
        return yesNoDialog.isAffirmative();
    }

    public void setGameMode(GameMode gameMode){
        this.gameMode=gameMode;
    }

    public static  void main(String[] args){
        new Connect4().play();
    }
}
