package com.example.futebas.model;

public class SoccerTeam {

    private int logo;
    private String name;
    private String city;

    private String achievements;

    public SoccerTeam(int logo, String name, String city, String achievements) {
        this.logo = logo;
        this.name = name;
        this.city = city;
        this.achievements = achievements;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

}
