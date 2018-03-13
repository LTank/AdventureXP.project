package com.adventure.xp.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@Controller
public class eventController {

    @RequestMapping(value = "/event", method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public @ResponseBody String pointUrl (@RequestParam("eventId")String eventId) {
        System.out.println(eventId);
        return "index";
    }
}
