package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.attribute.InstinctModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_infected_instinct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedInstinctModel {

    @EmbeddedId
    private InfectedInstinctId id = new InfectedInstinctId();

    @ManyToOne
    @MapsId("infectedId")
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @MapsId("instinctId")
    @JoinColumn(name = "instinct_id")
    private InstinctModel instinct;

    private Integer score;

}
