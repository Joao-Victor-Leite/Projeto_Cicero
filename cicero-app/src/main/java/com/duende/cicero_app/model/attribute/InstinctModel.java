package com.duende.cicero_app.model.attribute;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_instinct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstinctModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
