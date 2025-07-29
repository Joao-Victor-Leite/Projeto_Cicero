package com.duende.cicero_app.repository.attribute;

import com.duende.cicero_app.model.attribute.KnowledgeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeRepository extends JpaRepository <KnowledgeModel, Long> {}
