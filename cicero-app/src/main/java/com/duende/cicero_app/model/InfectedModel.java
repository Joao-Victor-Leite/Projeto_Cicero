package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "tb_infected")
@Getter
@Setter
public class InfectedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "health_id")
    private HealthModel health;

    private String name;
    private Integer healthTotal;
    private Integer healthCurrent;
    private Integer determination;
    private Integer determinationCurrent;
    private Integer assimilation;
    private Integer assimilationCurrent;
    private Integer bulkTotal;
    private Integer bulkCurrent;
    private Boolean susceptible;
}
