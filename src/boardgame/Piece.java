package boardgame;

public class Piece {
    protected Position position;// # protected
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

}
