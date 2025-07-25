package com.duende.cicero_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "tb_infected_origin")
@Getter
@Setter
public class InfectedOriginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private OriginModel origin;

    private Integer level;
    private String description;
}
