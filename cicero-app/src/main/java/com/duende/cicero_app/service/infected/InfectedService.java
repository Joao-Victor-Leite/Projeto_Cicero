package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.dto.infected.InfectedCreateDTO;
import com.duende.cicero_app.dto.infected.InfectedResponseDTO;
import com.duende.cicero_app.model.UserModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.repository.UserRepository;
import com.duende.cicero_app.repository.infected.InfectedRepository;
import com.duende.cicero_app.service.container.ContainerService;
import com.duende.cicero_app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class InfectedService {

    private final ContainerService containerService;
    private final InfectedGenerationService infectedGenerationService;
    private final InfectedRepository infectedRepository;
    private final InfectedMajorEventService infectedMajorEventService;
    private final InfectedOccupationService infectedOccupationService;
    private final UserRepository userRepository;

    @Autowired
    public InfectedService(
            ContainerService containerService,
            InfectedGenerationService infectedGenerationService,
            InfectedRepository infectedRepository,
            InfectedMajorEventService infectedMajorEventService,
            InfectedOccupationService infectedOccupationService,
            UserRepository userRepository
    ) {
        this.containerService = containerService;
        this.infectedGenerationService = infectedGenerationService;
        this.infectedRepository = infectedRepository;
        this.infectedMajorEventService = infectedMajorEventService;
        this.infectedOccupationService = infectedOccupationService;
        this.userRepository = userRepository;

    }

    // GET ALL
    public List<InfectedResponseDTO> findAllInfected() {
        return infectedRepository.findAll().stream()
                .map(InfectedResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public InfectedResponseDTO findInfectedById (Long id) {
        InfectedModel infected = infectedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Infectado não encontrado"));
        return InfectedResponseDTO.fromEntity(infected);
    }

    // CREATE
    public void createInfected (InfectedCreateDTO dto) {

        UserModel user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new NoSuchElementException("Usuario não encontrado"));

        InfectedModel infected = getInfectedModel(dto, user);

        infected = infectedRepository.save(infected);

        containerService.createDefaultContainers(infected);
        infectedGenerationService.linkGeneration(infected, dto.generationId(), dto.generationDescription());
        infectedMajorEventService.linkMajorEvent(infected, dto.majorEventId());
        infectedOccupationService.linkOccupation(infected, dto.occupationId());

        infectedRepository.save(infected);

    }

    // UPDATE
    public void updateInfected (Long id, InfectedCreateDTO dto) {

        InfectedModel infected = infectedRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Infectado não encontrado"));

        InfectedModel updatedData = getInfectedModel(dto, infected.getUser());
        Utils.copyNonNullProperties(updatedData, infected);
        InfectedModel savedData = infectedRepository.save(infected);

        InfectedResponseDTO.fromEntity(savedData);

    }

    // DELETE
    public void deleteInfected (Long id) {

        if (!infectedRepository.existsById(id)) {
            throw new RuntimeException("Infectado não existe");
        }

        infectedRepository.deleteById(id);

    }

    private static InfectedModel getInfectedModel(InfectedCreateDTO dto, UserModel user) {
        InfectedModel infected = new InfectedModel();
        infected.setName(dto.name());
        infected.setUser(user);
        infected.setDeterminationTotal(dto.determinationTotal());
        infected.setDeterminationCurrent(infected.getDeterminationTotal());
        infected.setAssimilationTotal(10 - dto.determinationTotal());
        infected.setAssimilationCurrent(infected.getAssimilationTotal());
        infected.setAttributeHealth(dto.attributeHealth());
        infected.setSusceptible(Boolean.FALSE);
        return infected;
    }

}
