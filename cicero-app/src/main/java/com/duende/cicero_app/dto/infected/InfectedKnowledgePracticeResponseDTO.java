package com.duende.cicero_app.dto.infected;

import com.duende.cicero_app.model.infected.InfectedKnowledgeModel;
import com.duende.cicero_app.model.infected.InfectedPracticeModel;

public record InfectedKnowledgePracticeResponseDTO(
        Long infectedId,
        Long attributeId,
        String type,
        String name,
        Integer score
) {

    public static InfectedKnowledgePracticeResponseDTO fromKnowledge (InfectedKnowledgeModel entity) {
        return new InfectedKnowledgePracticeResponseDTO(
                entity.getInfected().getId(),
                entity.getKnowledge().getId(),
                "KNOWLEDGE",
                entity.getKnowledge().getName(),
                entity.getScore()
        );
    }

    public static InfectedKnowledgePracticeResponseDTO fromPractice (InfectedPracticeModel entity) {
        return new InfectedKnowledgePracticeResponseDTO(
                entity.getInfected().getId(),
                entity.getPractice().getId(),
                "PRACTICE",
                entity.getPractice().getName(),
                entity.getScore()
        );
    }

}
