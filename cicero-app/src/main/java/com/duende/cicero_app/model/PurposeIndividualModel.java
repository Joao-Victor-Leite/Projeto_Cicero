package com.duende.cicero_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_purpose_individual")
@Getter
@Setter
public class PurposeIndividualModel extends PurposeModel{

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;
}
