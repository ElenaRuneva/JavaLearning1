package day17;

public enum ChessPiece {
    KING_WHITE(100, "♔"), KING_BLACK(100, "♚"), QUEEN_WHITE(9, "♕"), QUEEN_BLACK(9, "♛"),
    ROOK_WHITE(5, "♖"), ROOK_BLACK(5, "♜"), BISHOP_WHITE(3.5F, "♗"), BISHOP_BLACK(3.5F, "♝"),
    KNIGHT_WHITE(3, "♘"), KNIGHT_BLACK(3, "♞"), PAWN_WHITE(1, "♙"), PAWN_BLACK(1, "♟"),
    EMPTY(-1, "_");
    private float value;
    private String pic;
    private ChessPiece(float value, String pic){
        this.value = value;
        this.pic = pic;

        //вместо картинки подставляю строки, т.к. картинки не отображаются в консоли
        //можно эти строки удалить, тогда везде будут картинки
        if (this.name()!="EMPTY")
            this.pic = this.name().replace("WHITE", "W").replace("BLACK", "B");
    }
    public String toString(){
        return this.pic;
    }
}
