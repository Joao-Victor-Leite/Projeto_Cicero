package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "tb_instinct")
@Getter
@Setter
public class InstinctModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    public InstinctModel(){}
}
