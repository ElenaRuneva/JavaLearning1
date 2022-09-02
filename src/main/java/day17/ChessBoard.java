package day17;

public class ChessBoard {
    private ChessPiece[][] board = new ChessPiece[8][8];

    public ChessBoard(ChessPiece[][] board){
        this.board = board;
    }
    public void Print(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(this.board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
