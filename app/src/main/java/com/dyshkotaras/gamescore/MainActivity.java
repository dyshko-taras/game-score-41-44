package com.dyshkotaras.gamescore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Team1Score = 0, Team2Score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewTeam1Score = findViewById(R.id.textViewTeam1Score);
        TextView textViewTeam2Score = findViewById(R.id.textViewTeam2Score);

        textViewTeam1Score.setText(String.valueOf(Team1Score));

        textViewTeam2Score.setText(String.valueOf(Team2Score));

        textViewTeam1Score.setOnClickListener(View -> {
            textViewTeam1Score.setText(String.valueOf(++Team1Score));
            if (Team1Score == 10) launchResult("Team1 is winner", "team1");
        });
        textViewTeam2Score.setOnClickListener(View -> {
            textViewTeam2Score.setText(String.valueOf(++Team2Score));
            if (Team2Score == 10) launchResult("Team2 is winner", "team2");
        });
    }

    public void launchResult(String result, String color) {
        Intent intent = new Intent(this,Result.class);
        intent.putExtra("team", result);
        intent.putExtra("color",color);
        startActivity(intent);
    }
}