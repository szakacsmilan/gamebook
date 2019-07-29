package com.codecool.mainservice.repository;

import com.codecool.mainservice.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MonsterRepository extends JpaRepository<Monster, Long> {

    Monster findByName(String name);

}
