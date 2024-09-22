package boardgame;

public class Position {

    private int row;//Encapsulamento (private)
    private int column;

    public Position() {

    }

    public Position(int row, int column) {//Constructor
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    public void setValue(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {//sobreposição
        return  row +", "+ column;//imprime a posição linha e coluna na tela
    }
}
