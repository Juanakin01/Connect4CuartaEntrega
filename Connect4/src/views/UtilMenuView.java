package views;

import utils.Console;

public class UtilMenuView {

    public static int getInt(String string){
        return Console.getInstance().readInt(string);
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

    public static String readString(String string) {
        return Console.getInstance().readString(string);
    }
}
