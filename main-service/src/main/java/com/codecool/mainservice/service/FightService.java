package com.codecool.mainservice.service;

import com.codecool.mainservice.model.FightResult;
import com.codecool.mainservice.model.Monster;
import com.codecool.mainservice.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FightService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MonsterRepository monsterRepository;

    @Value("${fight.url}")
    private String fightUrl;

    public void saveFightDetails(){

        FightResult fightResult = restTemplate.getForEntity(fightUrl, FightResult.class).getBody();
        for (Monster monster : monsterRepository.findAll()) {
            if (monster.getName().equals("LizardKing")){
                monster.setHp(fightResult.getMonsterHp()    );
                monsterRepository.save(monster);
            } else if (monster.getName().equals("Player")){
                monster.setHp(fightResult.getPlayerHp());
                monsterRepository.save(monster);
            }
        }
        System.out.println(fightResult.toString());
    }
}
