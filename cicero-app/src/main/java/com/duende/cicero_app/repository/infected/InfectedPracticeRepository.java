package com.duende.cicero_app.repository.infected;

import com.duende.cicero_app.model.attribute.PracticeModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.model.infected.InfectedPracticeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfectedPracticeRepository extends JpaRepository <InfectedPracticeModel, Long> {

    Optional<InfectedPracticeModel> findByInfectedAndPractice(InfectedModel infected, PracticeModel practice);

    List<InfectedPracticeModel> findByInfected(InfectedModel infected);

}
