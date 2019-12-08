package com.project.fuc.kea.Team;

import com.project.fuc.kea.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public class TeamRepository {


    @Autowired
    private JdbcTemplate jdbc;




}




