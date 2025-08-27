package com.duende.cicero_app.repository.origin;

import com.duende.cicero_app.model.origin.OccupationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository <OccupationModel, Short> {}
