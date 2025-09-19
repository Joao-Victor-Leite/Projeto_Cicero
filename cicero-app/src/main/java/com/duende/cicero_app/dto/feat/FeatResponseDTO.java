package com.duende.cicero_app.dto.feat;

import com.duende.cicero_app.model.FeatModel;

public record FeatResponseDTO(
        Short id,
        String name,
        Integer cost,
        String description
) {

    public static FeatResponseDTO fromEntity (FeatModel feat) {
        return new FeatResponseDTO(
                feat.getId(),
                feat.getName(),
                feat.getCost(),
                feat.getDescription()
        );
    }

}
