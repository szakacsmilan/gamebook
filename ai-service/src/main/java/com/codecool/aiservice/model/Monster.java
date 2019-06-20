package com.codecool.aiservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Monster {

    private Long id;
    private String name;
    private Long hp;
    private Long dmg;
}
