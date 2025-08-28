package com.duende.cicero_app.service.origin;

import com.duende.cicero_app.dto.origin.generation.GenerationResponseDTO;
import com.duende.cicero_app.model.origin.GenerationModel;
import com.duende.cicero_app.repository.origin.GenerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenerationService {

    private final GenerationRepository generationRepository;

    @Autowired
    public GenerationService (GenerationRepository generationRepository) {
        this.generationRepository = generationRepository;
    }

    // GET ALL
    public List<GenerationResponseDTO> findAllGeneration () {

        return generationRepository.findAll()
                .stream()
                .map(GenerationResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public GenerationResponseDTO findGenerationById (Short id) {

        GenerationModel generation = generationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Geração não encontrado"));

        return GenerationResponseDTO.fromEntity(generation);

    }

}
