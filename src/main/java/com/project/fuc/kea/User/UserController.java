package com.project.fuc.kea.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user")
    @ResponseBody
    public User showUser(int id) {
        User user = userRepo.findUser(id);
        return user;
    }

    @GetMapping("/users")
    public String user(Model model) {
        List<User> userList = userRepo.findAllUsers();
        model.addAttribute("users", userList);
        return "show-users";
    }

    @GetMapping("/registeruser")
    public String addUser(Model model) {
        model.addAttribute("userform", new User());

        return "register";
    }

    //needs another redirect
    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute User user) {
        userRepo.insert(user);
        return "landing";

    }

    @GetMapping("/edituser/{user_id}")
    public String editUser(Model m, @PathVariable(name = "user_id") int id) {
        User userToEdit = userRepo.findUser(id);
        m.addAttribute("user", userToEdit);
        return "edit-user";
    }

    @PostMapping("/updateuser")
    public String saveEditUser(@ModelAttribute User user) {
        userRepo.update(user);
        return "redirect:/users";
    }

    @RequestMapping(value ={"/foosball"}, method = RequestMethod.POST)
    public String userLogin(@RequestParam Map<String,String> reqPar, Model model) {
        String email=reqPar.get("email");
        String password=reqPar.get("password");
        String name;
        for (User user : userRepo.findAllUsers()) {
            if (user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    name=user.getName();
                    model.addAttribute("name",name);
                    return "landing";
                }
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model){
        //model.addAttribute("user",userRepo.findUser(id));
        return "profile";
    }


}