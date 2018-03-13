package com.adventure.xp.controllers;

import com.adventure.xp.dao.repositories.ActivitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityController {

    @Autowired
    ActivitiesRepo ar;

    @RequestMapping(value = "/activitiesOverview", method = RequestMethod.GET)
    String index (Model model){

        model.addAttribute("activities", ar.readAll());
        return "activitiesOverview";
    }
}
