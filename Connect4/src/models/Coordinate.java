package models;

public class Coordinate {

        public static final int ROWS = 6;
        public static final int COLS = 7;
        private int row, col;

        public Coordinate(int x, int y) {
            this.row = x;
            this.col= y;
        }

        public int getPosRow() {
            return row;
        }

        public int getPosCol() {
            return col;
        }

         public void setRow(int row) {
            this.row = row;
         }

         public void setCol(int col) {
            this.col = col;
        }

        public static boolean outOfBounds(Coordinate coordinate){
            return coordinate.getPosCol()<0 ||
                    coordinate.getPosCol()>=COLS ||
                    coordinate.getPosRow()<0 ||
                    coordinate.getPosRow()>=ROWS;
        }
}
