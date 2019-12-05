package com.project.fuc.kea.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GameController {


        @Autowired
        private GameRepository gameRepo;

        @GetMapping("/all-games")
        public String showAll(Model model){
            List<Game> gameList = gameRepo.findAll();
            model.addAttribute("games", gameList);
            return "games-played";
        }

        @GetMapping("/add-game")
        public String addGame(Model m)
        {
            m.addAttribute("newGame", new Game());
            return "add-game";
        }

        @PostMapping("/add-game/save")
        public String saveGame(@ModelAttribute Game game, @ModelAttribute("a") String type)
        {
            return "redirect:/";
        }

        @GetMapping("/edit-game/{id}")
        public String editGame(@PathVariable("id") int id, Model model)
        {
            Game game  = gameRepo.findGame(id);
            model.addAttribute("editedGame", game);
            return "games/edit-game";
        }

        @PostMapping("/edit-game/save")
        public String saveEditedGame(@ModelAttribute Game game, @ModelAttribute("a") String type)
        {
            return "redirect:/game-saved";
        }
    }

