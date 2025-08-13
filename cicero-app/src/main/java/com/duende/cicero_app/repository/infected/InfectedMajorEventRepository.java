package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedMajorEventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedMajorEventRepository extends JpaRepository <InfectedMajorEventModel, Long> {}
