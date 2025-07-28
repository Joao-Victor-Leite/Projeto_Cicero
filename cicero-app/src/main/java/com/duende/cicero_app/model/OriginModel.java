package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tb_origin")
@Getter
@Setter
public class OriginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public OriginModel(){}
}
