package com.codecool.mainservice.controller;

import com.codecool.mainservice.model.Player;
import com.codecool.mainservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class GameController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/game")
    public String game(Model model){
        model.addAttribute("rooms", roomRepository.findAll());
        return "game";
    }



}
