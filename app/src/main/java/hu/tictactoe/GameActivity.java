package hu.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class GameActivity extends AppCompatActivity {

    private Button[][] buttons;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttons = new Button[3][3];

        buttons[0][0] = findViewById(R.id.button_00);
        buttons[0][1] = findViewById(R.id.button_01);
        buttons[0][2] = findViewById(R.id.button_02);
        buttons[1][0] = findViewById(R.id.button_10);
        buttons[1][1] = findViewById(R.id.button_11);
        buttons[1][2] = findViewById(R.id.button_12);
        buttons[2][0] = findViewById(R.id.button_20);
        buttons[2][1] = findViewById(R.id.button_21);
        buttons[2][2] = findViewById(R.id.button_22);

        game = new Game(this, buttons);
    }

    public void onClick(View view) {
        game.playerTurn(view);
        if(game.checkIfGameEnded()) {
            AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(GameActivity.this);
            myAlertBuilder.setTitle(R.string.end);
            if(game.getText().equals("X")) {
                myAlertBuilder.setMessage(R.string.won);
            }
            else if(game.getText().equals("O")) {
                myAlertBuilder.setMessage(R.string.lost);
            }
            else {
                myAlertBuilder.setMessage(R.string.draw);
            }
            myAlertBuilder.setPositiveButton(R.string.start_btn,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });

            myAlertBuilder.setNegativeButton(R.string.main_menu,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            myAlertBuilder.show();
        }

    }

    public void back(View view) {
        finish();
    }

}
