package com.codecool.aiservice.controller;

import com.codecool.aiservice.model.Monster;
import com.codecool.aiservice.model.Roll;
import com.codecool.aiservice.service.DiceRollService;
import com.codecool.aiservice.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fight")
public class FightController {

    @Autowired
    private MonsterService monsterService;

    @Autowired
    private DiceRollService diceRollService;

    @GetMapping("/{monster}")
    public List<Long> fight(@PathVariable("monster") String monster){
        Monster creature = monsterService.getMonster(monster);
        Monster player = monsterService.getMonster("player");
        List<Long> hps = new ArrayList<>();
        Roll heroRoll = new Roll(diceRollService.rollD6(), "D6");
        Roll monsterRoll = new Roll(diceRollService.rollD6(), "D6");
        hps.add(creature.getHp() - heroRoll.getResult() - player.getDmg());
        hps.add(player.getHp() - monsterRoll.getResult() - creature.getDmg());
        return hps;
    }

    @GetMapping("/a/{monster}")
    public Monster monster(@PathVariable("monster") String monster){
        return monsterService.getMonster("player");
    }

}
