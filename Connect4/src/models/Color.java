package models;

public enum Color {

    X,
    O,
    NULL;

    public static Color get(int ordinal){
        if(ordinal < 0 || ordinal > Color.NULL.ordinal()){
            throw new IndexOutOfBoundsException(utils.Error.OUT_OF_BOUNDS.getMessage());
        }
        return Color.values()[ordinal];
    }

    public boolean isNull() {
        return this == Color.NULL;
    }

}
