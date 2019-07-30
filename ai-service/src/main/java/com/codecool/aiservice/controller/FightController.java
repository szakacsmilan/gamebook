package com.codecool.aiservice.controller;

import com.codecool.aiservice.model.FightResult;
import com.codecool.aiservice.model.Monster;
import com.codecool.aiservice.model.Roll;
import com.codecool.aiservice.service.DiceRollService;
import com.codecool.aiservice.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:9090")
@RestController
@RequestMapping("/fight")
public class FightController {

    @Autowired
    private MonsterService monsterService;

    @Autowired
    private DiceRollService diceRollService;




    @GetMapping("/{monster}")
    public FightResult fight(@PathVariable("monster") String monster){
        Monster creature = monsterService.getMonster(monster);
        Monster player = monsterService.getMonster("player");
        FightResult fightResult = new FightResult();
        Roll heroRoll = new Roll(diceRollService.rollD6(), "D6");
        Roll monsterRoll = new Roll(diceRollService.rollD6(), "D6");
        fightResult.setMonsterHp(creature.getHp() - heroRoll.getResult() - player.getDmg());
        fightResult.setPlayerHp(player.getHp() - monsterRoll.getResult() - creature.getDmg());

        return fightResult;
    }

    @GetMapping("/a/{monster}")
    public Monster monster(@PathVariable("monster") String monster){
        return monsterService.getMonster("player");
    }

}
