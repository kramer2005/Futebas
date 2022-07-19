package com.example.futebas.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.futebas.R;

public class TeamDetailActivity extends AppCompatActivity {

    ImageView logo;
    TextView name, city;
    TextView achievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_detail_activity);
        Intent it = getIntent();
        logo = findViewById(R.id.logoImageView);
        name = findViewById(R.id.teamNameTextView);
        city = findViewById(R.id.cityTextView);
        achievements = findViewById(R.id.achievementsTextView);

        if(it != null) {
            Bundle params = it.getExtras();
            if(params != null) {
                name.setText(params.getString("teamName"));
                city.setText(params.getString("teamCity"));
                logo.setImageResource(params.getInt("teamLogo"));
                achievements.setText(params.getString("teamAchievements"));
            }
        }
    }
}