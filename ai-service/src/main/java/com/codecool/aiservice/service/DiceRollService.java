package com.codecool.aiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceRollService {

    public Long rollD6() {
        Random random = new Random();
        return Long.valueOf(random.nextInt(6) + 1);
    }

}
