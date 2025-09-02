package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.model.infected.InfectedOccupationModel;
import com.duende.cicero_app.model.origin.OccupationModel;
import com.duende.cicero_app.repository.infected.InfectedOccupationRepository;
import com.duende.cicero_app.repository.origin.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class InfectedOccupationService {

    private final OccupationRepository occupationRepository;
    private final InfectedOccupationRepository infectedOccupationRepository;

    @Autowired
    public InfectedOccupationService (
            InfectedOccupationRepository infectedOccupationRepository,
            OccupationRepository occupationRepository
    ) {
        this.infectedOccupationRepository = infectedOccupationRepository;
        this.occupationRepository = occupationRepository;
    }

    public void linkOccupation (InfectedModel infected, short occupationId) {

        OccupationModel occupation = occupationRepository.findById(occupationId)
                .orElseThrow(() -> new NoSuchElementException("Ocupação não encontrada"));

        InfectedOccupationModel infectedOccupation = new InfectedOccupationModel();
        infectedOccupation.setInfected(infected);
        infectedOccupation.setOccupation(occupation);
        infectedOccupation.setScoreTotal(1);
        infectedOccupation.setScoreCurrent(infectedOccupation.getScoreTotal());

        infectedOccupationRepository.save(infectedOccupation);

    }
}
