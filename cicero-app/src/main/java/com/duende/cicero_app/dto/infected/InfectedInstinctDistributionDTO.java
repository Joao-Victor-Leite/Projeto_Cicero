package com.duende.cicero_app.dto.infected;

import com.duende.cicero_app.service.infected.attributeDistribution.AttributeDistributionType;

import java.util.Map;

public record InfectedInstinctDistributionDTO (
        Long infectedId,
        AttributeDistributionType distributionType,
        Map<Long, Integer> instinctScores
) {
}
