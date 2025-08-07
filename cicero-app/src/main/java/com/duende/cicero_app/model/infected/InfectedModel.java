package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="tb_infected")
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

    private String name;
    private Integer healthTotal;
    private Integer healthCurrent;
    private Integer determinationTotal;
    private Integer determinationCurrent;
    private Integer assimilationTotal;
    private Integer assimilationCurrent;

    // pensar em como gerenciar a carga do personagem

    private Boolean susceptible = Boolean.FALSE;

    @OneToMany(mappedBy = "infected")
    private List<InfectedInstinctModel> instinctList;

}
