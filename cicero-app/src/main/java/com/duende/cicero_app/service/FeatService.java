package com.duende.cicero_app.service;

import com.duende.cicero_app.dto.feat.FeatCreateDTO;
import com.duende.cicero_app.dto.feat.FeatResponseDTO;
import com.duende.cicero_app.model.FeatModel;
import com.duende.cicero_app.repository.FeatRepository;
import com.duende.cicero_app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatService {

    private final FeatRepository featRepository;

    @Autowired
    public FeatService(FeatRepository featRepository) { this.featRepository = featRepository; }

    // GET ALL
    public List<FeatResponseDTO> findAllFeats() {
        return featRepository.findAll().stream()
                .map(FeatResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public FeatResponseDTO findFeatById(Long id) {
        FeatModel feat = featRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada com este id"));
        return FeatResponseDTO.fromEntity(feat);
    }

    // POST
    public FeatResponseDTO createFeat(FeatCreateDTO dto) {

        FeatModel feat = new FeatModel();
        feat.setName(dto.getName());
        feat.setCost(dto.getCost());
        feat.setDescription(dto.getDescription());

        FeatModel featSaved = featRepository.save(feat);
        return FeatResponseDTO.fromEntity(featSaved);
    }

    // PUT
    public FeatResponseDTO updateFeat(Long id, FeatCreateDTO dto) {
        FeatModel featExisting = featRepository.findById(id)
                .orElse(null);

        FeatModel featUpdated = new FeatModel();
        featUpdated.setName(dto.getName());
        featUpdated.setCost(dto.getCost());
        featUpdated.setDescription(dto.getDescription());

        Utils.copyNonNullProperties(featUpdated, featExisting);

        FeatModel featSaved = featRepository.save(featExisting);
        return FeatResponseDTO.fromEntity(featSaved);
    }

    // DELETE
    public void deleteFeat(Long id) {
        if(!featRepository.existsById(id)) {
            throw new RuntimeException("Habilidade não encontrada");
        }
        featRepository.deleteById(id);
    }

}
