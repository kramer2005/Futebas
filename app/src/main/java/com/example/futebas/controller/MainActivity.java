package com.example.futebas.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.futebas.R;
import com.example.futebas.adapter.AdapterTeams;
import com.example.futebas.model.SoccerTeam;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<SoccerTeam> teams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTeams();

        recyclerView = findViewById(R.id.recyclerViewTeams);

        AdapterTeams adapterTeams = new AdapterTeams(this, teams, recyclerView);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterTeams);
    }

    private void createTeams() {
        SoccerTeam soccerTeam = new SoccerTeam(R.drawable.coritiba, "Coritiba", "Curitiba - PR", "Campeonato Paranaense - 2012");
        teams.add(soccerTeam);
        soccerTeam = new SoccerTeam(R.drawable.corinthians, "Corinthians", "São Paulo - SP", "Mundial de Clubes - 2000\nMundial de Clubes - 2012");
        teams.add(soccerTeam);
        soccerTeam = new SoccerTeam(R.drawable.flamengo, "Flamengo", "Rio de Janeiro - RJ", "Libertadores - 2019\nMundial de Clubes - 1981");
        teams.add(soccerTeam);
        soccerTeam = new SoccerTeam(R.drawable.vasco, "Vasco da Gama", "Rio de Janeiro - RJ", "Coração do Brasileiro - Desde sempre");
        teams.add(soccerTeam);
    }
}