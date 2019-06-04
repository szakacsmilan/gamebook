package com.codecool.mainservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Monster monster;
    private String story;


}
