package com.adventure.xp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class eventController {

    @GetMapping (value = "/event")
    public String pointUrl () {
        return "index";
    }
}
