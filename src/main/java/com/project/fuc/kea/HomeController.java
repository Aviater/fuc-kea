package com.project.fuc.kea;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showAboutUs() {
        return "about";
    }
    @GetMapping("/login")
    public String index() {
        return "login-page";
    }

    @GetMapping({"/home"})
    public String showLanding() {
        return "landing";
    }
}
