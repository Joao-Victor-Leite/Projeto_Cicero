package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.attribute.KnowledgeModel;
import com.duende.cicero_app.model.infected.InfectedKnowledgeModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfectedKnowledgeRepository extends JpaRepository <InfectedKnowledgeModel, Long> {

    Optional<InfectedKnowledgeModel> findByInfectedAndKnowledge (InfectedModel infected, KnowledgeModel knowledge);

    List<InfectedKnowledgeModel> findByInfected (InfectedModel infected);

}
