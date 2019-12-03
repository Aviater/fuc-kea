package com.project.fuc.kea.User;

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
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbc;

    //find all users from the database
    public List<User> findAllUsers() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM user");
        List<User> userList = new ArrayList<>();

        while (rs.next()) {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));

        }

        return userList;
    }

    //find user by id

    public User findUser(int userId) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM user WHERE user_id= " + userId);
        User user = new User();

        while(rs.next()) {
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));

        }

        return user;
    }

  //update user

    public User update(User user) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("UPDATE user " + "SET name= ?, email= ?, password= ? " + "WHERE user_id= " + user.getUserId());
                ps.setString(1,user.getName());
                ps.setString(2,user.getEmail());
                ps.setString(3,user.getPassword());

                return ps;

            }

        };

        jdbc.update(psc);
        return user;


    }

    //insert new user in the database

    public User insert(User user) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement
                        ("INSERT INTO user(name,email,password) VALUES(?,?,?)");
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());

                return ps;
            }
        };
        jdbc.update(psc);
        return user;
    }

    /*  //find user by id and password *log in*
    public User login(String name, String password) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM user WHERE name= " + name +  "AND password= " + password);
        User userLogged = new User();

        while(rs.next()) {
            userLogged.setUserId(rs.getInt("user_id"));
            userLogged.setUserName(rs.getString("name"));
            userLogged.setEmail(rs.getString("email"));
            userLogged.setPassword(rs.getString("password"));

        }

        return userLogged;
    }*/
    }
