package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedOccupationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedOccupationRepository extends JpaRepository <InfectedOccupationModel, Long> {}
