package hu.tictactoe;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StatActivity extends AppCompatActivity {

    private int[] stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        stats = MainActivity.trans(preferences.getString("stats", null));

        TextView gamesPlayed = (TextView)findViewById(R.id.textView5);
        TextView wins = (TextView)findViewById(R.id.textView6);
        TextView ties = (TextView)findViewById(R.id.textView7);
        TextView losses = (TextView)findViewById(R.id.textView8);
        TextView winPercentage = (TextView)findViewById(R.id.textView9);

        double gp = stats[1];

        gamesPlayed.setText(gamesPlayed.getText().toString() + ": " + stats[0]);
        wins.setText(wins.getText().toString() + ": " + stats[1]);
        ties.setText(ties.getText().toString() + ": " + stats[2]);
        losses.setText(losses.getText().toString() + ": " + stats[3]);
        winPercentage.setText(winPercentage.getText().toString() + ": " + (stats[0] == 0 ? "0" : Math.floor((gp/stats[0])*100)) + "%");

    }
}
