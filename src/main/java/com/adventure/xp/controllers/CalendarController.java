package com.adventure.xp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CalendarController {

//    @GetMapping("/calendar")
//    public String calendar() {
//        return "calendar";
//    }

    @RequestMapping(path = "/calendar", method = RequestMethod.GET)
    String calendarShow (Model model){
        return "calendar";
    }

}
