package hu.tictactoe;

import android.app.Activity;
import android.widget.Button;

import java.util.Random;

public class Ai {
    private String symbol;
    private Button[][] board;
    private boolean myTurn = false;
    private Activity activity;

    public Ai(String symbol, Button[][] board, Activity activity) {
        this.symbol = symbol;
        this.board = board;
        this.activity = activity;
    }

    public void turn() {
        if (checkRowsIfWin()) return;
        if (checkColsIfWin()) return;
        if (checkDiagsIfWin()) return;
        if (checkRowsIfLose()) return;
        if (checkColsIfLose()) return;
        if (checkDiagsIfLose()) return;

        while(true) {
            final int min = 0;
            final int max = 2;
            int x = new Random().nextInt((max - min) + 1) + min;
            int y = new Random().nextInt((max - min) + 1) + min;

            if(board[x][y].getText().toString().isEmpty()) {
                board[x][y].setText(symbol);
                myTurn = false;
                break;
            }
        }
    }

    public boolean checkRowsIfWin() {
        for(int i=0; i<3; i++) {
            int numOfMySymbols = 0;
            Integer id = null;
            for(int j=0; j<3; j++) {
                if(board[i][j].getText() == symbol) {
                    numOfMySymbols++;
                }
                else if(board[i][j].getText().toString().isEmpty()){
                    id = board[i][j].getId();
                }
            }

            if(numOfMySymbols == 2 && id != null) {
                Button b = activity.findViewById(id);
                b.setText(symbol);
                myTurn = false;
                return true;
            }
        }

        return false;
    }

    public boolean checkColsIfWin() {
        for(int i=0; i<3; i++) {
            int numOfMySymbols = 0;
            Integer id = null;
            for(int j=0; j<3; j++) {
                if(board[j][i].getText() == symbol) {
                    numOfMySymbols++;

                }
                else if(board[j][i].getText().toString().isEmpty()){
                    id = board[j][i].getId();
                }
            }

            if(numOfMySymbols == 2 && id != null) {
                Button b = activity.findViewById(id);
                b.setText(symbol);
                myTurn = false;
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagsIfWin() {
        int numOfMySymbols = 0;
        Integer id = null;
        for(int i=0; i<3; i++) {
            if(board[i][i].getText() == symbol) {
                numOfMySymbols++;
            }
            else if(board[i][i].getText().toString().isEmpty()){
                id = board[i][i].getId();
            }


            if(numOfMySymbols == 2 && id != null) {
                Button b = activity.findViewById(id);
                b.setText(symbol);
                myTurn = false;
                return true;
            }
        }

        numOfMySymbols = 0;
        id = null;

        if(board[0][2].getText() == symbol) numOfMySymbols++;
        else if(board[0][2].getText().toString().isEmpty()) id = board[0][2].getId();

        if(board[1][1].getText() == symbol) numOfMySymbols++;
        else if(board[1][1].getText().toString().isEmpty()) id = board[1][1].getId();

        if(board[2][0].getText() == symbol) numOfMySymbols++;
        else if(board[2][0].getText().toString().isEmpty()) id = board[2][0].getId();

        if(numOfMySymbols == 2 && id != null) {
            Button b = activity.findViewById(id);
            b.setText(symbol);
            myTurn = false;
            return true;
        }

        return false;
    }

    public boolean checkRowsIfLose() {
        String enemy = symbol == "O" ? "X" : "O";

        for(int i=0; i<3; i++) {
            int numOfEnemySymbols = 0;
            Integer id = null;
            for(int j=0; j<3; j++) {
                if(board[i][j].getText() == enemy) {
                    numOfEnemySymbols++;
                }
                else if(board[i][j].getText().toString().isEmpty()){
                    id = board[i][j].getId();
                }
            }

            if(numOfEnemySymbols == 2 && id != null) {
                Button b = activity.findViewById(id);
                b.setText(symbol);
                myTurn = false;
                return true;
            }
        }

        return false;
    }

    public boolean checkColsIfLose() {
        String enemy = symbol == "O" ? "X" : "O";

        for(int i=0; i<3; i++) {
            int numOfEnemySymbols = 0;
            Integer id = null;
            for(int j=0; j<3; j++) {
                if(board[j][i].getText() == enemy) {
                    numOfEnemySymbols++;

                }
                else if(board[j][i].getText().toString().isEmpty()){
                    id = board[j][i].getId();
                }
            }

            if(numOfEnemySymbols == 2 && id != null) {
                Button b = activity.findViewById(id);
                b.setText(symbol);
                myTurn = false;
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagsIfLose() {
        String enemy = symbol == "O" ? "X" : "O";

        int numOfEnemySymbols = 0;
        Integer id = null;
        for(int i=0; i<3; i++) {
            if(board[i][i].getText() == enemy) {
                numOfEnemySymbols++;
            }
            else if(board[i][i].getText().toString().isEmpty()){
                id = board[i][i].getId();
            }


            if(numOfEnemySymbols == 2 && id != null) {
                Button b = activity.findViewById(id);
                b.setText(symbol);
                myTurn = false;
                return true;
            }
        }

        numOfEnemySymbols = 0;
        id = null;

        if(board[0][2].getText() == enemy) numOfEnemySymbols++;
        else if(board[0][2].getText().toString().isEmpty()) id = board[0][2].getId();

        if(board[1][1].getText() == enemy) numOfEnemySymbols++;
        else if(board[1][1].getText().toString().isEmpty()) id = board[1][1].getId();

        if(board[2][0].getText() == enemy) numOfEnemySymbols++;
        else if(board[2][0].getText().toString().isEmpty()) id = board[2][0].getId();

        if(numOfEnemySymbols == 2 && id != null) {
            Button b = activity.findViewById(id);
            b.setText(symbol);
            myTurn = false;
            return true;
        }

        return false;
    }
}
