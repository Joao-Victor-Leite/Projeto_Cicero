package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.origin.OccupationModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_infected_occupation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedOccupationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private OccupationModel occupation;

    private Integer scoreTotal = 1;
    private Integer scoreCurrent;

}
