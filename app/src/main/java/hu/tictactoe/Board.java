package hu.tictactoe;

public class Board {
    private final int x = 0;
    private final int o = 1;

    private int row;
    private int column;
    private Integer board[][];

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        this.board = new Integer[row][column];
    }

    public void putX(int row, int column) {
            if(this.board[row][column] == null) {
            this.board[row][column] = x;
        }
    }

    public void putO(int row, int column) {
        if(this.board[row][column] == null) {
            this.board[row][column] = o;
        }

    }
}
