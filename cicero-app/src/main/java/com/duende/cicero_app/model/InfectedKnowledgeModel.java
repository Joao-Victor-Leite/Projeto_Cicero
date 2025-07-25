package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "tb_infected_knowledge")
@Getter
@Setter
public class InfectedKnowledgeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @JoinColumn(name = "knowledge_id")
    private KnowledgeModel knowledge;

    private Integer value;
}
