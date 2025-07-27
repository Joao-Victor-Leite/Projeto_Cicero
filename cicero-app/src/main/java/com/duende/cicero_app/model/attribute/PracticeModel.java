package com.duende.cicero_app.model.attribute;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_practice")
@Getter
@Setter
public class PracticeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public PracticeModel() {}
}
