package com.adventure.xp.controllers;

import com.adventure.xp.dao.DButil.Util;
import com.adventure.xp.dao.repositories.ActivitiesRepo;
import com.adventure.xp.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivityController {

    @Autowired
    ActivitiesRepo ar;

    @Autowired
    Util util;

    @RequestMapping(value = "/activitiesOverview", method = RequestMethod.GET)
    String index (Model model) {
        model.addAttribute("activities", ar.readAll());
        return "activitiesOverview";
    }

    @RequestMapping (value = "/activityView", method = RequestMethod.GET)
    String editIndex (@RequestParam("activityId") int activityId, Model model) {
        boolean create = false;
        model.addAttribute("activity", ar.read(activityId));
        model.addAttribute("create", create);
        return "activity";
    }

    @RequestMapping (value = "/deleteActivity", method = RequestMethod.GET)
    String deleteActivity (@RequestParam("id") String id) {
        ar.delete(Integer.parseInt(id));
        return "redirect:/activitiesOverview";
    }

    @RequestMapping (value = "/activity", method = RequestMethod.POST)
    String updateActivity (@ModelAttribute("activity") Activity a) {
        if (a.getId() == 0 ) {
            ar.create(a);
            int id = util.readLastInsertID();
            ar.update(ar.read(id));
        }
        ar.update(a);
        return "redirect:/activitiesOverview";
    }

    @RequestMapping (value = "/createActivity", method = RequestMethod.GET)
    String createActivity (@ModelAttribute("activity") Activity a, Model model) {
        boolean create = true;
        model.addAttribute("create", create);
        return "activity";
    }



}
