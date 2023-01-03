package com.dyshkotaras.gamescore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Intent intent = getIntent();
        String result = intent.getStringExtra("team");
        String color = intent.getStringExtra("color");

        textViewResult.setText(result);
        if (color.equals("team1")) {
            textViewResult.setTextColor(getResources().getColor(R.color.team1color));
        }
        if (color.equals("team2")) {
            textViewResult.setTextColor(getResources().getColor(R.color.team2color));
        }

        textViewResult.setOnClickListener(View -> {
            launchMainActivity();
        });
    }

    public void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}