package com.duende.cicero_app.dto.infected;

import com.duende.cicero_app.model.infected.AttributeHealth;

import java.util.UUID;

public record InfectedCreateDTO(
        UUID userId,
        String name,
        Integer determinationTotal,
        AttributeHealth attributeHealth,
        Short generationId,
        String generationDescription,
        Short majorEventId,
        Short occupationId
) {
}
