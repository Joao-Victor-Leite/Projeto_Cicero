package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedRepository extends JpaRepository <InfectedModel, Long> {}
