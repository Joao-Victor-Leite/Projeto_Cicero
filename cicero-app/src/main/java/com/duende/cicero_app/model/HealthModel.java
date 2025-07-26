package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tb_health")
@Getter
@Setter
public class HealthModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer box;
    private String description;
    private Integer boxSequence;

    public HealthModel(){}
}
