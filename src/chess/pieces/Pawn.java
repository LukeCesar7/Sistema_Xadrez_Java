package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch Chessmatch;

    public Pawn(Board board, Color color, ChessMatch chessmatch) {
        super(board, color);
        this.Chessmatch = chessmatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getColumns()][getBoard().getRows()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValue(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][position.getColumn()] = true;
            }
            p.setValue(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][position.getColumn()] = true;
            }
            p.setValue(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && !isThereOpponentPiece(p)) {
                mat[p.getRow()][position.getColumn()] = true;
            }
            p.setValue(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && !isThereOpponentPiece(p)) {
                mat[p.getRow()][position.getColumn()] = true;
            }
            //enPassant
            if(position.getRow() ==3 ){
                Position left = new Position(position.getRow(), position.getColumn()-1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == Chessmatch.getEnPassantVulnerable()) {
                    mat[left.getRow()-1][left.getColumn()] = true;
                }

                    Position right = new Position(position.getRow(), position.getColumn()+1);
                    if(getBoard().positionExists(left) && isThereOpponentPiece(right) && getBoard().piece(right) == Chessmatch.getEnPassantVulnerable()) {
                        mat[right.getRow()-1][right.getColumn()] = true;
                    }
            }
        }
        else {
            p.setValue(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][position.getColumn()] = true;
            }
            p.setValue(position.getRow() +2, position.getColumn());
            Position p2 = new Position(position.getRow() +1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][position.getColumn()] = true;
            }
            p.setValue(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && !isThereOpponentPiece(p)) {
                mat[p.getRow()][position.getColumn()] = true;
            }
            p.setValue(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && !isThereOpponentPiece(p)) {
                mat[p.getRow()][position.getColumn()] = true;
            }
                if(position.getRow() ==4 ){
                    Position left = new Position(position.getRow(), position.getColumn()-1);
                    if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == Chessmatch.getEnPassantVulnerable()) {
                        mat[left.getRow()+1][left.getColumn()] = true;
                    }
                        Position right = new Position(position.getRow(), position.getColumn()+1);
                        if(getBoard().positionExists(left) && isThereOpponentPiece(right) && getBoard().piece(right) == Chessmatch.getEnPassantVulnerable()) {
                            mat[right.getRow()+1][right.getColumn()] = true;
                        }
                    }

        }
        return mat;
    }

    @Override
    public String toString() {
        return "p";
    }
}