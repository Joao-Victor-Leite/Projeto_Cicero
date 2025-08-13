package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedKnowledgeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedKnowledgeRepository extends JpaRepository <InfectedKnowledgeModel, Long> {}
