package com.example.futebas.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futebas.R;
import com.example.futebas.controller.MainActivity;
import com.example.futebas.controller.TeamDetailActivity;
import com.example.futebas.model.SoccerTeam;

import java.util.List;

public class AdapterTeams extends RecyclerView.Adapter<AdapterTeams.TeamsViewHolder>{

    private final List<SoccerTeam> soccerTeams;
    RecyclerView recyclerView;
    MainActivity parent;
    protected final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = recyclerView.getChildLayoutPosition(view);
            SoccerTeam team = soccerTeams.get(itemPosition);
            Intent it = new Intent(parent, TeamDetailActivity.class);

            Bundle params = new Bundle();
            params.putString("teamName", team.getName());
            params.putString("teamCity", team.getCity());
            params.putInt("teamLogo", team.getLogo());
            params.putString("teamAchievements", team.getAchievements());
            it.putExtras(params);

            parent.startActivity(it);
        }
    };

    public AdapterTeams(MainActivity parent, List<SoccerTeam> soccerTeams, RecyclerView view) {
        this.parent = parent;
        this.soccerTeams = soccerTeams;
        this.recyclerView = view;
    }

    public static class TeamsViewHolder extends RecyclerView.ViewHolder {

        TextView teamName, city;
        ImageView teamLogo;

        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);

            teamName = itemView.findViewById(R.id.adapterTeamNameTextView);
            city = itemView.findViewById(R.id.adapterCityTextView);
            teamLogo = itemView.findViewById(R.id.adapterTeamLogo);
        }
    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_list_adapter, parent, false);
        listItem.setOnClickListener(mOnClickListener);

        return new TeamsViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, int position) {
        SoccerTeam team = soccerTeams.get(position);

        holder.teamName.setText(team.getName());
        holder.city.setText(team.getCity());
        holder.teamLogo.setImageResource(team.getLogo());
    }

    @Override
    public int getItemCount() {
        return soccerTeams.size();
    }

}
