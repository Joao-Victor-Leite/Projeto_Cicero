package com.duende.cicero_app.dto.health;

import com.duende.cicero_app.model.HealthModel;
import lombok.Getter;

@Getter
public class HealthResponseDTO {

    private Long id;
    private Integer box;
    private String description;

    public static  HealthResponseDTO fromEntity(HealthModel health) {

        HealthResponseDTO dto = new HealthResponseDTO();
        dto.id = health.getId();
        dto.box = health.getBox();
        dto.description = health.getDescription();

        return dto;
    }
}
