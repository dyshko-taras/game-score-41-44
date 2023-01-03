package com.dyshkotaras.gamescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int team1Score = 0;
    int team2Score = 0;
    private TextView textViewTeam1Score;
    private TextView textViewTeam2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTeam1Score = findViewById(R.id.textViewTeam1Score);
        textViewTeam2Score = findViewById(R.id.textViewTeam2Score);

        if (savedInstanceState != null) {
            team1Score = savedInstanceState.getInt("team1Score");
            team2Score = savedInstanceState.getInt("team2Score");
        }

        updateTeam1Score();
        updateTeam2Score();

        textViewTeam1Score.setOnClickListener(View -> {
            Log.d("MainActivity", "clicked textViewTeam1Score");
            team1Score++;
            updateTeam1Score();
            if (team1Score == 10) launchResult("Team1 is winner", "team1");
        });
        textViewTeam2Score.setOnClickListener(View -> {
            Log.d("MainActivity", "clicked textViewTeam2Score");
            team2Score++;
            updateTeam2Score();
            if (team2Score == 10) launchResult("Team2 is winner", "team2");
        });
    }

    public void updateTeam1Score() {
        textViewTeam1Score.setText(String.valueOf(team1Score));
    }
    public void updateTeam2Score() {
        textViewTeam2Score.setText(String.valueOf(team2Score));
    }

    public void launchResult(String result, String color) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("team", result);
        intent.putExtra("color", color);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("MainActivity", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("team1Score", team1Score);
        outState.putInt("team2Score", team2Score);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity", "onDestroy");
        super.onDestroy();
    }
}