package com.duende.cicero_app.dto.infected;

import java.util.Map;

public record InfectedKnowledgePracticeDistributionDTO(
        Long InfectedId,
        Map<Long, Integer> knowledgeScores,
        Map<Long, Integer> practiceScores
) {
}
