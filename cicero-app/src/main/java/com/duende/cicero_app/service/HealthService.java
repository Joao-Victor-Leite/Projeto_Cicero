package com.duende.cicero_app.service;

import com.duende.cicero_app.dto.health.HealthResponseDTO;
import com.duende.cicero_app.model.HealthModel;
import com.duende.cicero_app.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthService {

    private final HealthRepository healthRepository;
    
    @Autowired
    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }
    
    // GET ALL
    public List<HealthResponseDTO> findAllHealths() {
        return healthRepository.findAll().stream()
                .map(HealthResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public HealthResponseDTO findHealthById(Long id) {
        HealthModel health = healthRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caixa de vida não existe"));
        return HealthResponseDTO.fromEntity(health);
    }
}
