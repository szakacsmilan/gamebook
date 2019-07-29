package com.codecool.aiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class DiceRollService {

    public Long rollD6() {
        Random random = new Random();
        return Long.valueOf(random.nextInt(6) + 1);
    }



    public static String maxSubstring(String s) {
        // Write your code here
        List<String> chars = new ArrayList<>();

        for (int i = 0; i <s.length() ; i++) {
            String temp = "";
            temp += s.charAt(i);
            if (!chars.contains(temp)){
                chars.add(temp);
            }
            for (int j = i+1; j <s.length(); j++) {
                temp += s.charAt(j);
                if (!chars.contains(temp)){
                    chars.add(temp);
                }
            }
        }
        Collections.sort(chars);
        int lastIndex = chars.size();
        return chars.get(lastIndex);

    }

}
