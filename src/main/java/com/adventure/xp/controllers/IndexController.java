package com.adventure.xp.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
