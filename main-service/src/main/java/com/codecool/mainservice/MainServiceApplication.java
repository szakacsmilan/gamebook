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
                    .name("LizardKing")
                    .dmg(6L)
                    .hp(100L)
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
                    .dmg(8L)
                    .hp(100L)
                    .build();


            monsterRepository.saveAll(Lists.newArrayList(player, lizard, spider, dragon));

        };
    }

}
