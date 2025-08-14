package com.duende.cicero_app.service.item;

import com.duende.cicero_app.dto.item.quality.QualityResponseDTO;
import com.duende.cicero_app.model.item.QualityModel;
import com.duende.cicero_app.repository.item.QualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualityService {

    private final QualityRepository qualityRepository;

    @Autowired
    public QualityService(QualityRepository qualityRepository) {
        this.qualityRepository = qualityRepository;
    }

    // GET ALL
    public List<QualityResponseDTO> findAllQualities() {
        return qualityRepository.findAll().stream()
                .map(QualityResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public QualityResponseDTO findQualityById(Long id) {
        QualityModel quality = qualityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Qualidade não encontrada"));
        return QualityResponseDTO.fromEntity(quality);
    }

}
