package com.adventure.xp.controllers;

import com.adventure.xp.dao.repositories.UserRepo;
import com.adventure.xp.models.User;
import com.adventure.xp.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepo ur = new UserRepo();

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String allUsers(Model model){
        model.addAttribute("users", ur.readAll());
        return "users";
    }

    @RequestMapping(value = {"/createUser"}, method = RequestMethod.GET)
    public String userCreation(Model model){
        model.addAttribute("newUser", new User());
        return "createUser";
    }

    @RequestMapping (value = {"/createUser"}, method = RequestMethod.POST)
    public String create(@ModelAttribute User u) {
        ur.create(u);
        return "redirect:calendar";
    }

    @RequestMapping(value = {"/userDetails"}, method = RequestMethod.GET)
    public String userDetails(@RequestParam("userId") String id, Model model){
        model.addAttribute("u", ur.read(Integer.parseInt(id))); //read details of user
        return "userDetails";
    }
}
