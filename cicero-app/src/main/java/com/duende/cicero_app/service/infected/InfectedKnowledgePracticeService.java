package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.dto.infected.InfectedKnowledgePracticeDistributionDTO;
import com.duende.cicero_app.dto.infected.InfectedKnowledgePracticeResponseDTO;
import com.duende.cicero_app.model.attribute.KnowledgeModel;
import com.duende.cicero_app.model.attribute.PracticeModel;
import com.duende.cicero_app.model.infected.InfectedKnowledgeModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.repository.attribute.KnowledgeRepository;
import com.duende.cicero_app.repository.attribute.PracticeRepository;
import com.duende.cicero_app.repository.infected.InfectedKnowledgeRepository;
import com.duende.cicero_app.repository.infected.InfectedPracticeRepository;
import com.duende.cicero_app.repository.infected.InfectedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InfectedKnowledgePracticeService {

    private final InfectedRepository infectedRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final PracticeRepository practiceRepository;
    private final InfectedKnowledgeRepository infectedKnowledgeRepository;
    private final InfectedPracticeRepository infectedPracticeRepository;

    @Autowired
    public InfectedKnowledgePracticeService (
            InfectedRepository infectedRepository,
            KnowledgeRepository knowledgeRepository,
            PracticeRepository practiceRepository,
            InfectedKnowledgeRepository infectedKnowledgeRepository,
            InfectedPracticeRepository infectedPracticeRepository
    ) {
        this.infectedRepository = infectedRepository;
        this.knowledgeRepository = knowledgeRepository;
        this.practiceRepository = practiceRepository;
        this.infectedKnowledgeRepository = infectedKnowledgeRepository;
        this.infectedPracticeRepository = infectedPracticeRepository;
    }

    public List<InfectedKnowledgePracticeResponseDTO> applyKnowledgePracticePoints (InfectedKnowledgePracticeDistributionDTO dto) {
        InfectedModel infected = infectedRepository.findById(dto.InfectedId())
                .orElseThrow(() -> new NoSuchElementException("Infected não encontrado"));

        int totalPoints = dto.knowledgeScores().values().stream().mapToInt(Integer::intValue).sum()
                + dto.practiceScores().values().stream().mapToInt(Integer::intValue).sum();

        if (totalPoints != 7) {
            throw new IllegalArgumentException("A distribuição deve totalizar exatamente 7 pontos, recebido: " + totalPoints);
        }

        List<KnowledgeModel> knowledge = knowledgeRepository.findAll();
        if (knowledge.size() != 6) {
            throw new IllegalStateException("Esperado exatamente 6 Conhecimentos cadastrados.");
        }

        List<PracticeModel> practice = practiceRepository.findAll();
        if (practice.size() != 6) {
            throw new IllegalStateException("Esperado exatamente 6 Práticas cadastrados.");
        }

        dto.knowledgeScores().forEach((knowledgeId, score) -> {
            KnowledgeModel knowledgeModel = knowledgeRepository.findById(knowledgeId)
                    .orElseThrow(() -> new NoSuchElementException("Conhecimento não encontrado"));

            var infectedKnowledge = infectedKnowledgeRepository.findByInfectedAndKnowledge(infected, knowledgeModel)
                    .orElseGet(() -> new InfectedKnowledgeModel(infected, knowledgeModel));;

            infectedKnowledge.setScore(score);
            infectedKnowledgeRepository.save(infectedKnowledge);
        });

        dto.practiceScores().forEach((practiceId, score) -> {
            PracticeModel practiceModel = practiceRepository.findById(practiceId)
                    .orElseThrow(() -> new NoSuchElementException("Prática não encontrada: " + practiceId));

            var infectedPractice = infectedPracticeRepository.findByInfectedAndPractice(infected, practiceModel)
                    .orElseGet(() -> new com.duende.cicero_app.model.infected.InfectedPracticeModel(infected, practiceModel));

            infectedPractice.setScore(score);
            infectedPracticeRepository.save(infectedPractice);
        });

        List<InfectedKnowledgePracticeResponseDTO> responseList = new ArrayList<>();

        infectedKnowledgeRepository.findByInfected(infected)
                .forEach(ik -> responseList.add(InfectedKnowledgePracticeResponseDTO.fromKnowledge(ik)));

        infectedPracticeRepository.findByInfected(infected)
                .forEach(ip -> responseList.add(InfectedKnowledgePracticeResponseDTO.fromPractice(ip)));

        return responseList;
    }



}
