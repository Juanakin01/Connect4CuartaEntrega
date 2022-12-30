package views;

import models.Color;
import models.Coordinate;
import utils.Console;

public class Views {

    int menu;

    public void setMenu(int menu){
        this.menu=menu;
    }

    public static int getInt(String string){
        return Console.getInstance().readInt(string);
    }



    public static void showBoard(Color[][] colors) {
        for (int i = Coordinate.ROWS-1; i >= 0; i--) {
            for (int j = 0; j < Coordinate.COLS; j++) {
                if (colors[i][j].isNull()) {
                    System.out.print("|\t \t");
                } else {
                    System.out.print("|\t" + colors[i][j] + "\t");
                }
            }
            System.out.print("|\n");
        }
        System.out.println();
    }

    public static void writeln(String string){
        Console.getInstance().writeln(string);
    }

    public static void write(String string){
        Console.getInstance().write(string);
    }

    public static void writeln(){
        Console.getInstance().writeln();
    }

    public static String readString(String string){
        return Console.getInstance().readString(string);
    }
}
