package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedInstinctId;
import com.duende.cicero_app.model.infected.InfectedInstinctModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfectedInstinctRepository extends JpaRepository <InfectedInstinctModel, InfectedInstinctId> {}
