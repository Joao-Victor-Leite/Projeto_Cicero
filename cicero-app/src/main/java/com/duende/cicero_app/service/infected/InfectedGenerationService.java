package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.model.infected.InfectedGenerationModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.model.origin.GenerationModel;
import com.duende.cicero_app.repository.origin.GenerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InfectedGenerationService {

    private final GenerationRepository generationRepository;

    @Autowired
    public InfectedGenerationService (GenerationRepository generationRepository) {
        this.generationRepository = generationRepository;
    }

    public void linkGeneration (InfectedModel infected, short generationId, String description) {

        GenerationModel generation = generationRepository.findById(generationId)
                .orElseThrow(() -> new NoSuchElementException("Geração não encontrada"));

        InfectedGenerationModel infectedGeneration = new InfectedGenerationModel();
        infectedGeneration.setInfected(infected);
        infectedGeneration.setGeneration(generation);
        infectedGeneration.setDescription(description);
        infectedGeneration.setScoreTotal(1);
        infectedGeneration.setScoreCurrent(infectedGeneration.getScoreTotal());

        infected.setGenerationList(new ArrayList<>(List.of(infectedGeneration)));
        
    }
}
