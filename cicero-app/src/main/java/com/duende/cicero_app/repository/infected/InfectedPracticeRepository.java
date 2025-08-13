package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedPracticeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedPracticeRepository extends JpaRepository <InfectedPracticeModel, Long> {}
