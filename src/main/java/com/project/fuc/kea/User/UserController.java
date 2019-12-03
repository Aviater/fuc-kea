package com.project.fuc.kea.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user")
    @ResponseBody
    public User showUser(){
        User user = userRepo.findUser(1);
        return user;
    }

    @GetMapping("/users")
    public String user(Model model){
        List<User> userList=userRepo.findAllUsers();
        model.addAttribute("users",userList);
        return "show-users";
    }

    @GetMapping("/registeruser")
    public String addUser(Model model){
        model.addAttribute("userform",new User());
        return "register-user";
    }

    //needs another redirect
    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute User user){
        userRepo.insert(user);
        return "redirect:/users";
    }

    @GetMapping("/edituser/{user_id}")
    public String editUser (Model m, @PathVariable(name="user_id") int id){
        User userToEdit = userRepo.findUser(id);
        m.addAttribute("user",userToEdit);
        return "edit-user";
    }

    @PostMapping("/updateuser")
    public String saveEditUser(@ModelAttribute User user){
        userRepo.update(user);
        return "redirect:/users";
    }

}
