package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "tb_feat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer cost;

    @Lob
    private String description;

}
