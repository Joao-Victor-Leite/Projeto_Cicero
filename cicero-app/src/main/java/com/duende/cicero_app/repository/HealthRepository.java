package com.duende.cicero_app.repository;

import com.duende.cicero_app.model.HealthModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository <HealthModel, Long> {}
