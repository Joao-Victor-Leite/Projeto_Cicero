package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.attribute.KnowledgeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_infected_knowledge")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedKnowledgeModel {

    @EmbeddedId
    private InfectedKnowledgeId id = new InfectedKnowledgeId();

    @ManyToOne
    @MapsId("infectedId")
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @ManyToOne
    @MapsId("knowledgeId")
    @JoinColumn(name = "knowledge_id")
    private KnowledgeModel knowledge;

    private Integer score;

    public InfectedKnowledgeModel(InfectedModel infected, KnowledgeModel knowledgeModel) {}

}
