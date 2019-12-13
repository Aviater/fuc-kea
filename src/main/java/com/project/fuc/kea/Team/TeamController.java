package com.project.fuc.kea.Team;

import com.project.fuc.kea.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class TeamController {

    @Autowired
    private TeamRepository teamRepo;
}


//
//    //Show teams
//    @GetMapping("/teams")
//    public String showAllTeams(Model model) {
//        List<Team> teamList = teamRepo.findAllTeams();
//        model.addAttribute("teams", teamList);
//        return "/teams/teams";
//    }
//
//
//    @PostMapping("/create-team")
//    public String saveTeam(@ModelAttribute("newTeam") Team team, Model model) {
//
//        List<User> players = new ArrayList<User>();
//
////
//        switch(option)
//        {
//
//
//        }
//



        //randomly assigned


        // dropdown list



