package com.codecool.mainservice;

import com.codecool.mainservice.model.Monster;
import com.codecool.mainservice.model.Room;
import com.codecool.mainservice.repository.MonsterRepository;
import com.codecool.mainservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainServiceApplication {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private RoomRepository roomRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {

            Monster dragon = Monster.builder()
                    .dmg(6L)
                    .hp(12L)
                    .build();

            monsterRepository.save(dragon);

//            Room room = Room.builder()
//                    .monster(dragon)
//                    .story("Egyszer volt hol nem volt ...")
//                    .build();
//
//            roomRepository.save(room);

        };
    }

}
