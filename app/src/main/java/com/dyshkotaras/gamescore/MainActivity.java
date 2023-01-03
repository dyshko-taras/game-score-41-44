package com.dyshkotaras.gamescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int team1Score = 0, team2Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            team1Score = savedInstanceState.getInt("team1Score");
            team2Score = savedInstanceState.getInt("team2Score");
        }


        TextView textViewTeam1Score = findViewById(R.id.textViewTeam1Score);
        TextView textViewTeam2Score = findViewById(R.id.textViewTeam2Score);

        textViewTeam1Score.setText(String.valueOf(team1Score));
        textViewTeam2Score.setText(String.valueOf(team2Score));

        textViewTeam1Score.setOnClickListener(View -> {
            textViewTeam1Score.setText(String.valueOf(++team1Score));
            if (team1Score == 10) launchResult("Team1 is winner", "team1");
        });
        textViewTeam2Score.setOnClickListener(View -> {
            textViewTeam2Score.setText(String.valueOf(++team2Score));
            if (team2Score == 10) launchResult("Team2 is winner", "team2");
        });
    }

    public void launchResult(String result, String color) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("team", result);
        intent.putExtra("color", color);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("team1Score", team1Score);
        outState.putInt("team2Score", team2Score);
    }
}