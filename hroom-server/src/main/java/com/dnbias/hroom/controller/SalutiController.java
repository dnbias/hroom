package com.dnbias.hroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saluti")
public class SalutiController {

    @GetMapping(value="/test")
    public String getSaluti(){
        return "saluti, prova web spring";
    }
}
