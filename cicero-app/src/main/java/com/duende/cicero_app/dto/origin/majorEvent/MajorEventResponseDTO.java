package com.duende.cicero_app.dto.origin.majorEvent;

import com.duende.cicero_app.model.origin.OccupationModel;

public record MajorEventResponseDTO (String name) {
    public static MajorEventResponseDTO fromEntity (OccupationModel occupation) {
        return new MajorEventResponseDTO(occupation.getName());
    }
}
