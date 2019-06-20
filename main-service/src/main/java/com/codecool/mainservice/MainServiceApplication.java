package com.codecool.mainservice;

import com.codecool.mainservice.model.Monster;
import com.codecool.mainservice.model.Room;
import com.codecool.mainservice.repository.MonsterRepository;
import com.codecool.mainservice.repository.RoomRepository;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class MainServiceApplication {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private RoomRepository roomRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {

            Monster lizard = Monster.builder()
                    .name("Lizard")
                    .dmg(10L)
                    .hp(10L)
                    .build();

            Monster spider = Monster.builder()
                    .name("GiantSpider")
                    .dmg(3L)
                    .hp(20L)
                    .build();

            Monster dragon = Monster.builder()
                    .name("Dragon")
                    .dmg(6L)
                    .hp(12L)
                    .build();

            Monster player = Monster.builder()
                    .name("Player")
                    .dmg(6L)
                    .hp(30L)
                    .build();


            monsterRepository.saveAll(Lists.newArrayList(player, lizard, spider, dragon));

            Room room1 = Room.builder()
                    .monster(spider)
                    .story("en kicsi pok")
                    .build();

            Room room2 = Room.builder()
                    .story("szia itt nincs semmi")
                    .build();

            Room room3 = Room.builder()
                    .monster(dragon)
                    .story("en kicsi sarkanyom")
                    .build();

            Room room4 = Room.builder()
                    .story("itt van egy hp")
                    .build();

            Room room5 = Room.builder()
                    .monster(lizard)
                    .story("szia en vagyok a gyikember")
                    .build();

            roomRepository.saveAll(Lists.newArrayList(room1, room2, room3, room4, room5));

        };
    }

}
