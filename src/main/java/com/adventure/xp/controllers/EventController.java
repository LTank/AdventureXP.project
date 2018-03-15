package com.adventure.xp.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class EventController {

    @RequestMapping(value = "/event", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public @ResponseBody String eventUrl (@RequestParam(value ="eventId")String id) {
        System.out.println(id);
        return "index";
    }
}
