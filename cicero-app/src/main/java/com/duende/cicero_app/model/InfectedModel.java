package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_infected")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @Column(nullable = false)
    private String name;

    private Integer healthTotal;
    private Integer healthCurrent;
    private Integer determinationTotal;
    private Integer determinationCurrent;
    private Integer assimilationTotal;
    private Integer assimilationCurrent;
    private Integer weightTotal;
    private Integer weightCurrent;
    private Boolean susceptible;

}
