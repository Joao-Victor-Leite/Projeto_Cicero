package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.origin.MajorEventModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_infected_major_event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedMajorEventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @JoinColumn(name = "major_event_id")
    private MajorEventModel majorEvent;

    private Integer scoreTotal = 1;
    private Integer scoreCurrent;

}
