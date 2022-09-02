package day17;

public class Task1 {
    public static void main(String[] args) {
        ChessPiece[] chessArray = new ChessPiece[8];
        for (int i=0; i<4; i++)
            chessArray[i] = ChessPiece.PAWN_WHITE;
        for (int i=4; i<8; i++)
            chessArray[i] = ChessPiece.ROOK_BLACK;
        for (int i=0; i<chessArray.length; i++)
            System.out.print(chessArray[i] + " ");
    }
}