package com.codecool.aiservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player {
    private String name;
    private Long hp;
    private Long dmg;
}
