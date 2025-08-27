package com.duende.cicero_app.dto.origin.occupation;

import com.duende.cicero_app.model.origin.OccupationModel;

public record OccupationResponseDTO (String name) {
    public static OccupationResponseDTO fromEntity (OccupationModel occupation) {
        return new OccupationResponseDTO(occupation.getName());
    }
}
