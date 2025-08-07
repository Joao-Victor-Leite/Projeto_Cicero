package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.origin.GenerationModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_infected_generation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedGenerationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @JoinColumn(name = "generation_id")
    private GenerationModel generationList;

    private Integer scoreTotal = 1;
    private Integer scoreCurrent;

}
