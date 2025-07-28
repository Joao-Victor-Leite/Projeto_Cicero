package com.duende.cicero_app.service;

import com.duende.cicero_app.dto.origin.OriginResponseDTO;
import com.duende.cicero_app.model.OriginModel;
import com.duende.cicero_app.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OriginService {

    private final OriginRepository originRepository;

    @Autowired
    public OriginService(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    // GET ALL
    public List<OriginResponseDTO> findAllOrigins() {
        return originRepository.findAll().stream()
                .map(OriginResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public OriginResponseDTO findOriginById(Long id) {
        OriginModel origin = originRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Origem não encontrada"));
        return OriginResponseDTO.fromEntity(origin);
    }
}
