package com.project.fuc.kea.Team;

import com.project.fuc.kea.Game.Game;
import com.project.fuc.kea.User.User;

import java.util.List;

public class Team {
    private int team_id;
    private String name;
    private List <User> players;
    private Game game;
   // private boolean isWinner;



    public Team(int team_id, String name, List<User> players, Game game) {
        this.team_id = team_id;
        this.name = name;
        this.players = players;
        this.game = game;
    }

    public int getTeam_id() {
        return team_id;
    }
    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }
}
