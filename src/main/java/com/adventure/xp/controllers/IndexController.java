package com.adventure.xp.controllers;

import com.adventure.xp.dao.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @Autowired
    UserRepo userRepo = new UserRepo();

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:calendar";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("users", userRepo.readAll()); // Shows users from database

        return "login";
    }




    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }

}
