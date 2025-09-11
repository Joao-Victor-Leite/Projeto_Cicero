package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.dto.infected.InfectedInstinctDistributionDTO;
import com.duende.cicero_app.dto.infected.InfectedInstinctResponseDTO;
import com.duende.cicero_app.model.attribute.InstinctModel;
import com.duende.cicero_app.model.infected.InfectedInstinctId;
import com.duende.cicero_app.model.infected.InfectedInstinctModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.repository.attribute.InstinctRepository;
import com.duende.cicero_app.repository.infected.InfectedInstinctRepository;
import com.duende.cicero_app.repository.infected.InfectedRepository;
import com.duende.cicero_app.service.infected.attributeDistribution.AttributeDistributionConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class InfectedInstinctService {

    private final InfectedRepository infectedRepository;
    private final InstinctRepository instinctRepository;
    private final InfectedInstinctRepository infectedInstinctRepository;
    private final AttributeDistributionConfig distributionConfig;
    private final InfectedHealthAttributeService infectedHealthAttributeService;

    @Autowired
    public InfectedInstinctService(
            InfectedRepository infectedRepository,
            InstinctRepository instinctRepository,
            InfectedInstinctRepository infectedInstinctRepository,
            AttributeDistributionConfig distributionConfig,
            InfectedHealthAttributeService infectedHealthAttributeService
    ) {
        this.infectedRepository = infectedRepository;
        this.instinctRepository = instinctRepository;
        this.infectedInstinctRepository = infectedInstinctRepository;
        this.distributionConfig = distributionConfig;
        this.infectedHealthAttributeService = infectedHealthAttributeService;
    }

    public List<InfectedInstinctResponseDTO> applyDistribution(InfectedInstinctDistributionDTO dto) {
        InfectedModel infected = infectedRepository.findById(dto.infectedId())
                .orElseThrow(() -> new NoSuchElementException("Infected não encontrado"));

        List<InstinctModel> instincts = instinctRepository.findAll();
        if (instincts.size() != 6) {
            throw new IllegalStateException("Esperado exatamente 6 Instintos cadastrados.");
        }

        List<Integer> chosenValues = dto.instinctScores().values().stream().sorted().toList();
        List<Integer> expectedValues = distributionConfig.getDistribution(dto.distributionType()).stream().sorted().toList();

        if (!chosenValues.equals(expectedValues)) {
            throw new IllegalArgumentException("Disribuição inválida para o tipo" + dto.distributionType());
        }

        List<InfectedInstinctResponseDTO> responseList = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : dto.instinctScores().entrySet()) {
            InstinctModel instinct = instinctRepository.findById(entry.getKey())
                    .orElseThrow(() -> new NoSuchElementException("Instinct não encontrado: " + entry.getKey()));

            InfectedInstinctId id = new InfectedInstinctId(infected.getId(), instinct.getId());

            InfectedInstinctModel infectedInstinct = new InfectedInstinctModel();
            infectedInstinct.setId(id);
            infectedInstinct.setInfected(infected);
            infectedInstinct.setInstinct(instinct);
            infectedInstinct.setScore(entry.getValue());

            infectedInstinctRepository.save(infectedInstinct);
            responseList.add(InfectedInstinctResponseDTO.fromEntity(infectedInstinct));

        }

        infectedHealthAttributeService.calculateHealth(infected);
        infectedRepository.save(infected);

        return responseList;
    }
}
