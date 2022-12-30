package views;

import models.Color;
import models.Coordinate;

public class BoardView {

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
}
