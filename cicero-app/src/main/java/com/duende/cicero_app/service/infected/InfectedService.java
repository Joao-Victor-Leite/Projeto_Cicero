package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.dto.infected.InfectedCreateDTO;
import com.duende.cicero_app.model.UserModel;
import com.duende.cicero_app.model.infected.InfectedGenerationModel;
import com.duende.cicero_app.model.infected.InfectedMajorEventModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.model.infected.InfectedOccupationModel;
import com.duende.cicero_app.model.item.ContainerModel;
import com.duende.cicero_app.model.item.ContainerType;
import com.duende.cicero_app.model.origin.GenerationModel;
import com.duende.cicero_app.model.origin.MajorEventModel;
import com.duende.cicero_app.model.origin.OccupationModel;
import com.duende.cicero_app.repository.UserRepository;
import com.duende.cicero_app.repository.infected.InfectedMajorEventRepository;
import com.duende.cicero_app.repository.infected.InfectedOccupationRepository;
import com.duende.cicero_app.repository.infected.InfectedRepository;
import com.duende.cicero_app.repository.item.ContainerRepository;
import com.duende.cicero_app.repository.origin.GenerationRepository;
import com.duende.cicero_app.repository.origin.MajorEventRepository;
import com.duende.cicero_app.repository.origin.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InfectedService {

    private final ContainerRepository containerRepository;
    private final GenerationRepository generationRepository;
    private final InfectedRepository infectedRepository;
    private final InfectedMajorEventRepository infectedMajorEventRepository;
    private final InfectedOccupationRepository infectedOccupationRepository;
    private final MajorEventRepository majorEventRepository;
    private final OccupationRepository occupationRepository;
    private final UserRepository userRepository;

    @Autowired
    public InfectedService(ContainerRepository containerRepository,
                           GenerationRepository generationRepository,
                           InfectedRepository infectedRepository,
                           InfectedMajorEventRepository infectedMajorEventRepository,
                           InfectedOccupationRepository infectedOccupationRepository,
                           MajorEventRepository majorEventRepository,
                           OccupationRepository occupationRepository,
                           UserRepository userRepository
                           ) {
        this.containerRepository = containerRepository;
        this.generationRepository = generationRepository;
        this.infectedRepository = infectedRepository;
        this.infectedMajorEventRepository = infectedMajorEventRepository;
        this.infectedOccupationRepository = infectedOccupationRepository;
        this.majorEventRepository = majorEventRepository;
        this.occupationRepository = occupationRepository;
        this.userRepository = userRepository;

    }

    // CREATE
    public InfectedModel createInfected (InfectedCreateDTO dto) {

        UserModel user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new NoSuchElementException("Usuario não encontrado"));

        InfectedModel infected = new InfectedModel();
        infected.setName(dto.name());
        infected.setUser(user);
        infected.setDeterminationTotal(dto.determinationTotal());
        infected.setDeterminationCurrent(infected.getDeterminationTotal());
        infected.setAssimilationTotal(10 - dto.determinationTotal());
        infected.setAssimilationCurrent(infected.getAssimilationTotal());
        infected.setAttributeHealth(dto.attributeHealth());
        infected.setSusceptible(Boolean.FALSE);

        infected = infectedRepository.save(infected);

        // Lógica para criação de inventário do personagem
        ContainerModel personal = new ContainerModel();
        personal.setType(ContainerType.PERSONAL);
        personal.setTotalSize(2);
        personal.setCurrentSize(0);
        personal.setInfected(infected);

        ContainerModel backpack = new ContainerModel();
        backpack.setType(ContainerType.BACKPACK);
        backpack.setTotalSize(6);
        backpack.setCurrentSize(0);
        backpack.setInfected(infected);

        containerRepository.saveAll(List.of(personal, backpack));

        infected.setContainerList(List.of(personal, backpack));
        infected = infectedRepository.save(infected);

        // Lógica de ínculo entre infectado e sua geraçã́o
        GenerationModel generation = generationRepository.findById(dto.generationId())
                .orElseThrow(() -> new NoSuchElementException("Geração não encontrada"));

        InfectedGenerationModel infectedGeneration = new InfectedGenerationModel();
        infectedGeneration.setInfected(infected);
        infectedGeneration.setGeneration(generation);
        infectedGeneration.setDescription(dto.generationDescription());
        infectedGeneration.setScoreTotal(1);
        infectedGeneration.setScoreCurrent(infectedGeneration.getScoreTotal());

        infected.setGenerationList(List.of(infectedGeneration));

        // Lógica de ínculo entre infectado e seu evento marcante
        MajorEventModel majorEvent = majorEventRepository.findById(dto.majorEventId())
                .orElseThrow(() -> new NoSuchElementException("Evento marcante não encontrado"));

        InfectedMajorEventModel infectedMajorEvent = new InfectedMajorEventModel();
        infectedMajorEvent.setInfected(infected);
        infectedMajorEvent.setMajorEvent(majorEvent);
        infectedMajorEvent.setScoreTotal(1);
        infectedMajorEvent.setScoreCurrent(infectedMajorEvent.getScoreTotal());

        infectedMajorEventRepository.save(infectedMajorEvent);

        // Lógica de ínculo entre infectado e sua ocupação
        OccupationModel occupation = occupationRepository.findById(dto.occupationId())
                .orElseThrow(() -> new NoSuchElementException("Ocupação não encontrado"));

        InfectedOccupationModel infectedOccupation = new InfectedOccupationModel();
        infectedOccupation.setInfected(infected);
        infectedOccupation.setOccupation(occupation);
        infectedOccupation.setScoreTotal(1);
        infectedOccupation.setScoreCurrent(infectedOccupation.getScoreTotal());

        infectedOccupationRepository.save(infectedOccupation);

        return infectedRepository.save(infected);

    }

    
}
