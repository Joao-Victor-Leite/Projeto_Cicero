package com.duende.cicero_app.service.origin;

import com.duende.cicero_app.dto.origin.occupation.OccupationCreateDTO;
import com.duende.cicero_app.dto.origin.occupation.OccupationResponseDTO;
import com.duende.cicero_app.model.origin.OccupationModel;
import com.duende.cicero_app.repository.origin.OccupationRepository;
import com.duende.cicero_app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccupationService {

    private final OccupationRepository occupationRepository;

    @Autowired
    public OccupationService (OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    // GET ALL
    public List<OccupationResponseDTO> findAllOccupations () {

        return occupationRepository.findAll()
                .stream()
                .map(OccupationResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public OccupationResponseDTO findOccupationById (Short id) {

        OccupationModel occupation = occupationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ocupação nao encontrado"));

        return OccupationResponseDTO.fromEntity(occupation);

    }

    // CREATE
    public void createOccupation (OccupationCreateDTO dto) {

        OccupationModel occupation = new OccupationModel();
        occupation.setName(dto.name());
        occupationRepository.save(occupation);

    }

    // UPDATE
    public void updateOccupation(Short id, OccupationCreateDTO dto) {

        OccupationModel occupation = occupationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ocupação não encontrado"));
        Utils.copyNonNullProperties(dto, occupation);
        OccupationModel updated = occupationRepository.save(occupation);

        OccupationResponseDTO.fromEntity(updated);

    }

    // DELETE
    public void deleteOccupation (Short id) {

        if (!occupationRepository.existsById(id)) {
            throw new RuntimeException("Ocupação não existe");
        }

        occupationRepository.deleteById(id);

    }
}
