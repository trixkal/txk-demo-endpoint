package com.example.demotxk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTxkController {

    @GetMapping("/testHeroku/")
    public String testHeroku() {

        return "ResponseEntity.OK.Heroku";
    }
}
