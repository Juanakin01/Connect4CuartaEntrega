package utils;

import views.UtilMenuView;


public enum Error {
    COLUMN_FULL("The column is full, choose another one"),
    OUT_OF_BOUNDS("The column is out of bounds, choose another one"),
    NO_UNDO_OPTION("No more undo options"),
    NO_REDO_OPTION("No more redo options"),
    NULL;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    public void writeln() {
        if (!this.isNull()) {
            UtilMenuView.writeln(this.message);
        }
    }

    public boolean isNull() {
        return this == Error.NULL;
    }

    public String getMessage(){
        return this.message;
    }

}