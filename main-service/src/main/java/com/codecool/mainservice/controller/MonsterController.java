package com.codecool.mainservice.controller;

import com.codecool.mainservice.model.Monster;
import com.codecool.mainservice.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    @Autowired
    private MonsterRepository monsterRepository;

    @GetMapping("/spider")
    public Monster spider(){
        for (Monster monster: monsterRepository.findAll()) {
            if(monster.getName().equals("GiantSpider")){
                return monster;
            }
        }
        return null;
    }

    @GetMapping("/dragon")
    public Monster dragon(){
        for (Monster monster: monsterRepository.findAll()) {
            if(monster.getName().equals("Dragon")){
                return monster;
            }
        }
        return null;
    }

    @GetMapping("/lizard")
    public Monster lizard(){
        for (Monster monster: monsterRepository.findAll()) {
            if(monster.getName().equals("LizardKing")){
                return monster;
            }
        }
        return null;
    }

    @GetMapping("/player")
    public Monster player(){
        for (Monster monster: monsterRepository.findAll()) {
            if(monster.getName().equals("Player")){
                return monster;
            }
        }
        return null;
    }
}
