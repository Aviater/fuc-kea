package com.project.fuc.kea.Game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepository {

    @Autowired
    private JdbcTemplate jdbc;


    public List<Game> findAll() {
        String query = "SELECT * from game_id";

        SqlRowSet rs = jdbc.queryForRowSet(query);
        List<Game> gameList = new ArrayList<>();

        return getGamePlayedList(gameList, rs);
    }

    public Game findGame(int id) {
        String query = "SELECT * FROM game WHERE game_id = ? ;";

        SqlRowSet rs = jdbc.queryForRowSet(query, id);
        Game game = new Game();

        try {

            if (rs.first()) {
                getGame(rs, game);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }


    public void insertGame(Game game) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO game values(null, ?, ?, ?)");
                ps.setString(1, game.getWinner());
                ps.setString(2, game.getType());
                ps.setInt(3, game.getDuration());
                return ps;
            }
        };
        jdbc.update(psc);
    }


    private void getGame(SqlRowSet rs, Game game) {

        game.setGame_id(rs.getInt("game_id"));
        game.setWinner(rs.getString("winner"));
        game.setType(rs.getString("type"));
        game.setDuration(rs.getInt("duration"));
    }

    private List<Game> getGamePlayedList(List<Game> gameList, SqlRowSet rs) {
        try {
            while (rs.next()) {
                Game game = new Game();
                getGame(rs, game);
                gameList.add(game);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
          return gameList;
    }

}

