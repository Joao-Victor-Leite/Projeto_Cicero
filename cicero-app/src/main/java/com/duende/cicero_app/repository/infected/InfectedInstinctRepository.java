package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.infected.InfectedInstinctId;
import com.duende.cicero_app.model.infected.InfectedInstinctModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfectedInstinctRepository extends JpaRepository <InfectedInstinctModel, InfectedInstinctId> {

    List<InfectedInstinctModel> findByInfectedId(Long infectedId);

}
