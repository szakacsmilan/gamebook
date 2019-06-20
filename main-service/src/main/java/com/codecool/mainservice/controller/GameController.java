package com.codecool.mainservice.controller;

import com.codecool.mainservice.model.Monster;
import com.codecool.mainservice.model.Player;
import com.codecool.mainservice.repository.MonsterRepository;
import com.codecool.mainservice.repository.RoomRepository;
import com.codecool.mainservice.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class GameController {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private FightService fightService;

    @GetMapping("/game")
    public String game(Model model){

        Monster lizardKing = null;
        Monster player = null;
        boolean monsterHasHp = true;
        boolean playerHasHp = true;

        for (Monster monster : monsterRepository.findAll()) {
            if (monster.getName().equals("LizardKing")){
                lizardKing = monster;
            } else if (monster.getName().equals("Player")){
                player = monster;
            }
        }

        if (lizardKing.getHp()<= 0){
            monsterHasHp = false;
        }

        if (player.getHp()<=0){
            playerHasHp = false;
        }

        model.addAttribute("monster", lizardKing);
        model.addAttribute("player", player);

        model.addAttribute("monsterdead", monsterHasHp);
        model.addAttribute("playerdead", playerHasHp);

        return "game";
    }


    @PostMapping("/game")
    public String fight(){

        fightService.saveFightDetails();

        return "redirect:/game";
    }





}
