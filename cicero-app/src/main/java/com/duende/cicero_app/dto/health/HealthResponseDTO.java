package com.duende.cicero_app.dto.health;

import com.duende.cicero_app.model.HealthModel;


public record HealthResponseDTO (
        Integer box,
        String description
) {

    public static  HealthResponseDTO fromEntity(HealthModel health) {
        return new HealthResponseDTO(
                health.getBox(),
                health.getDescription()
        );
    }
}
