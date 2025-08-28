package com.duende.cicero_app.service.origin;

import com.duende.cicero_app.dto.origin.majorEvent.MajorEventCreateDTO;
import com.duende.cicero_app.dto.origin.majorEvent.MajorEventResponseDTO;
import com.duende.cicero_app.model.origin.MajorEventModel;
import com.duende.cicero_app.repository.origin.MajorEventRepository;
import com.duende.cicero_app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MajorEventService {

    private final MajorEventRepository majorEventRepository;

    @Autowired
    public MajorEventService (MajorEventRepository majorEventRepository) {
        this.majorEventRepository = majorEventRepository;
    }

    // GET ALL
    public List<MajorEventResponseDTO> findAllMajorEvents () {

        return majorEventRepository.findAll()
                .stream()
                .map(MajorEventResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public MajorEventResponseDTO findMajorEventById (Short id) {

        MajorEventModel majorEvent = majorEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento Marcante não encontrado"));

        return MajorEventResponseDTO.fromEntity(majorEvent);

    }

    // CREATE
    public void createMajorEvent (MajorEventCreateDTO dto) {

        MajorEventModel majorEvent = new MajorEventModel();
        majorEvent.setName(dto.name());
        majorEventRepository.save(majorEvent);

    }

    // UPDATE
    public void updateMajorEvent (Short id, MajorEventCreateDTO dto) {

        MajorEventModel majorEvent = majorEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento Marcante não encontrado"));
        Utils.copyNonNullProperties(dto, majorEvent);
        MajorEventModel updated = majorEventRepository.save(majorEvent);

        MajorEventResponseDTO.fromEntity(updated);

    }

    // DELETE
    public void deleteMajorEvent (Short id) {

        if (!majorEventRepository.existsById(id)) {
            throw new RuntimeException("Evento marcante não existe");
        }

        majorEventRepository.deleteById(id);

    }

}
