package com.duende.cicero_app.service.attribute;

import com.duende.cicero_app.dto.attribute.knowledge.KnowledgeResponseDTO;
import com.duende.cicero_app.model.attribute.KnowledgeModel;
import com.duende.cicero_app.repository.attribute.KnowledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    @Autowired
    public KnowledgeService(KnowledgeRepository knowledgeRepository) { this.knowledgeRepository = knowledgeRepository; }

    // GET ALL
    public List<KnowledgeResponseDTO> findAllKnowledge() {
        return knowledgeRepository.findAll().stream()
                .map(KnowledgeResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public KnowledgeResponseDTO findKnowledgeById(Long id) {
        KnowledgeModel knowledge = knowledgeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conhecimento não existe"));
        return KnowledgeResponseDTO.fromEntity(knowledge);
    }
}
