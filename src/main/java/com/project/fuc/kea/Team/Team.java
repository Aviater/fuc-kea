package com.project.fuc.kea.Team;

public class Team {
    private int team_id;
    private int player1_id;
    private int player2_id;
    private int points;
    private int game_id;

    public int getTeam_id() {
        return team_id;
    }
    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getPlayer1_id() {
        return player1_id;
    }
    public void setPlayer1_id(int player1_id) {
        this.player1_id = player1_id;
    }

    public int getPlayer2_id() {
        return player2_id;
    }
    public void setPlayer2_id(int player2_id) {
        this.player2_id = player2_id;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public int getGame_id() {
        return game_id;
    }
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
}
