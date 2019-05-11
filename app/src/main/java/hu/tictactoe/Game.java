package hu.tictactoe;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class Game {

    private Activity activity;
    private boolean end;
    private Ai ai;
    private Button[][] buttons;
    private int blocksLeft;
    private String text;

    public Game(Activity activity, Button[][] buttons) {
        this.activity = activity;
        this.end = false;
        this.blocksLeft = 9;
        this.buttons = buttons;
        this.ai = new Ai("O", buttons, this.activity);
    }

    public void playerTurn(View view) {
        int id = view.getId();
        if(!end) {
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    if (id == buttons[i][j].getId() && buttons[i][j].getText().toString().isEmpty()) {
                        buttons[i][j].setText("X");
                        blocksLeft--;
                        checkIfGameEnded();
                        computerTurn();
                    }
                }
            }
        }
    }

    public void computerTurn() {
        if(!end) {
            ai.turn();
            blocksLeft--;
            checkIfGameEnded();
        }
    }

    public boolean checkIfGameEnded() {
        if(blocksLeft == 0) {
            end = true;
            text = "D";
            return end;
        }
        checkRowsIfGameEnded();
        checkColsIfGameEnded();
        checkDiagsIfGameEnded();

        return end;
    }

    public void checkRowsIfGameEnded() {
        for(int i=0; i<3; i++) {
            if(!buttons[i][0].getText().toString().isEmpty() && buttons[i][0].getText() == buttons[i][1].getText() && buttons[i][0].getText() == buttons[i][2].getText()) {
                end = true;
                text = buttons[i][0].getText().toString();
            }
        }
    }

    public void checkColsIfGameEnded() {
        for(int i=0; i<3; i++) {
            if(!buttons[0][i].getText().toString().isEmpty() && buttons[0][i].getText() == buttons[1][i].getText() && buttons[0][i].getText() == buttons[2][i].getText()) {
                end = true;
                text = buttons[0][i].getText().toString();
            }
        }
    }

    public void checkDiagsIfGameEnded() {
        if(!buttons[0][0].getText().toString().isEmpty() && buttons[0][0].getText() == buttons[1][1].getText() && buttons[0][0].getText() == buttons[2][2].getText()) {
            end = true;
            text = buttons[0][0].getText().toString();
        }
        else if(!buttons[2][0].getText().toString().isEmpty() && buttons[2][0].getText() == buttons[1][1].getText() && buttons[2][0].getText() == buttons[0][2].getText()) {
            end = true;
            text = buttons[2][0].getText().toString();
        }
    }

    public String getText() {
        return this.text;
    }
}
