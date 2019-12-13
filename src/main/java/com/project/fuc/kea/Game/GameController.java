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


        @GetMapping("/registergame")
        public String addGame(Model m)
        {
            m.addAttribute("gameform", new Game());
            return "add-game";
        }

        @GetMapping("/match")
        public String saveNewGame(@ModelAttribute Game game, @ModelAttribute("a") String type)
       {   gameRepo.insertGame(game);
            return "newMatch";
        }

        //could be used for ranking or to see all games

        @GetMapping("/all-games")
        public String showAll(Model model){
            List<Game> gameList = gameRepo.findAll();
            model.addAttribute("games", gameList);
            return "games-played";
        }
        @PostMapping("/savegame")
        public String saveGame(@ModelAttribute Game game, @ModelAttribute("a") String type)
        {   gameRepo.insertGame(game);
            return "landing";
        }

}

