package com.duende.cicero_app.model.attribute;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_instinct")
@Getter
@Setter
public class InstinctModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public InstinctModel() {}
}
