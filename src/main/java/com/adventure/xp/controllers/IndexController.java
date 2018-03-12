package com.adventure.xp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/index")
    public String index() {
        return "calendar";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }

}
