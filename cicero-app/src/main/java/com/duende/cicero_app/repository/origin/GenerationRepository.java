package com.duende.cicero_app.repository.origin;

import com.duende.cicero_app.model.origin.GenerationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerationRepository extends JpaRepository <GenerationModel, Short> {}
