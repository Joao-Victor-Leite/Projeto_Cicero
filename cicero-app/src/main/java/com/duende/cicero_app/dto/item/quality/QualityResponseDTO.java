package com.duende.cicero_app.dto.item.quality;

import com.duende.cicero_app.model.item.QualityModel;

public record QualityResponseDTO (
        Integer cost,
        Integer category,
        String name,
        String description
) {

    public static QualityResponseDTO fromEntity(QualityModel quality) {
        return new QualityResponseDTO(
                quality.getCost(),
                quality.getCategory(),
                quality.getName(),
                quality.getDescription()
        );
    }
}
