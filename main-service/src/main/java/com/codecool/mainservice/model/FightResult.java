package com.codecool.mainservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FightResult {
    private Long monsterHp;
    private Long playerHp;
}
