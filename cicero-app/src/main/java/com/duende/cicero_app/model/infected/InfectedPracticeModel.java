package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.attribute.PracticeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_infected_practice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedPracticeModel {

    @EmbeddedId
    private InfectedPracticeId id = new InfectedPracticeId();

    @ManyToOne
    @MapsId("infectedId")
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @MapsId("practiceId")
    @JoinColumn(name = "practice_id")
    private PracticeModel practice;

    private Integer score;
}
