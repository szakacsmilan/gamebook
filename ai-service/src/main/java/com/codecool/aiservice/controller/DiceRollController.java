package com.codecool.aiservice.controller;

import com.codecool.aiservice.model.Roll;
import com.codecool.aiservice.service.DiceRollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roll")
public class DiceRollController {

    @Autowired
    private DiceRollService service;

    @GetMapping("/d6")
    public Roll rollD6(){
        return new Roll(
                service.rollD6(),
                "D6"
        );
    }
}
