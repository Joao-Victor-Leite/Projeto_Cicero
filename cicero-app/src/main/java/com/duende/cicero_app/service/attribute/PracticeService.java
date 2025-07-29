package com.duende.cicero_app.service.attribute;

import com.duende.cicero_app.dto.attribute.practice.PracticeResponseDTO;
import com.duende.cicero_app.model.attribute.PracticeModel;
import com.duende.cicero_app.repository.attribute.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PracticeService {

    private final PracticeRepository practiceRepository;

    @Autowired
    public PracticeService(PracticeRepository practiceRepository) { this.practiceRepository = practiceRepository; }

    // GET ALL
    public List<PracticeResponseDTO> findAllPractice() {
        return practiceRepository.findAll().stream()
                .map(PracticeResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public PracticeResponseDTO findPracticeById(Long id) {
        PracticeModel practice = practiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prática não existe"));
        return PracticeResponseDTO.fromEntity(practice);
    }
}
