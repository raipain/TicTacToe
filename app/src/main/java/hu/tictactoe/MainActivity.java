package hu.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        String stats = prefs.getString("stats", null);
        if(stats == null) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("stats", "games_played:0;wins:0;ties:0;losses:0");
            editor.commit();
        }

        setContentView(R.layout.activity_main);

        newGame = findViewById(R.id.button);

    }

    public void newGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void statistics(View view) {
        Intent intent = new Intent(this, StatActivity.class);
        startActivity(intent);
    }

    public static int[] trans(String stats) {
        if(stats == null) return null;

        int[] ret = new int[4];
        String[] afterSplit;

        afterSplit = stats.split(";");
        ret[0] = Integer.parseInt(afterSplit[0].split(":")[1]);
        ret[1] = Integer.parseInt(afterSplit[1].split(":")[1]);
        ret[2] = Integer.parseInt(afterSplit[2].split(":")[1]);
        ret[3] = Integer.parseInt(afterSplit[3].split(":")[1]);

        return ret;
    }
}
