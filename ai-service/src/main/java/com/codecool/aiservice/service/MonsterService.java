package com.codecool.aiservice.service;

import com.codecool.aiservice.model.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MonsterService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${monster.url}")
    private String monsterUrl;

    public Monster getMonster(String monsterName){
        return restTemplate.getForEntity(monsterUrl + monsterName, Monster.class).getBody();
    }
}
