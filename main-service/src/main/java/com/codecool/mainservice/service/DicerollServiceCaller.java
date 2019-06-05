package com.codecool.mainservice.service;

import com.codecool.mainservice.model.RollResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class DicerollServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${roll.url}")
    private String rollUrl;

    public int roll(){
        return restTemplate.getForEntity(rollUrl, RollResult.class).getBody().getResult();
    }
}
