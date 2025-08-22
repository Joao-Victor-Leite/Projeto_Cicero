package com.duende.cicero_app.dto.infected;

import com.duende.cicero_app.model.infected.AttributeHealth;

import java.util.UUID;

public record InfectedCreateDTO(
        UUID userId,
        String name,
        Integer determinationTotal,
        AttributeHealth attributeHealth,
        Long generationId,
        String generationDescription,
        Long majorEventId,
        Long occupationId
) {
}
