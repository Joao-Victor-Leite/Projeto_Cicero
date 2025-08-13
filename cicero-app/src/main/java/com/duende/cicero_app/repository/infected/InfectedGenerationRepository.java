package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedGenerationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedGenerationRepository extends JpaRepository <InfectedGenerationModel, Long> {}
