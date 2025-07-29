package com.duende.cicero_app.service.attribute;

import com.duende.cicero_app.dto.attribute.instinct.InstinctResponseDTO;
import com.duende.cicero_app.model.attribute.InstinctModel;
import com.duende.cicero_app.repository.attribute.InstinctRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstinctService {

    private final InstinctRepository instinctRepository;

    @Autowired
    public InstinctService(InstinctRepository instinctRepository) { this.instinctRepository = instinctRepository; }

    // GET ALL
    public List<InstinctResponseDTO> findAllInstincts() {
        return instinctRepository.findAll().stream()
                .map(InstinctResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public InstinctResponseDTO findInstinctById(Long id) {
        InstinctModel instinct = instinctRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instinto não existe"));
        return InstinctResponseDTO.fromEntity(instinct);
    }
}
