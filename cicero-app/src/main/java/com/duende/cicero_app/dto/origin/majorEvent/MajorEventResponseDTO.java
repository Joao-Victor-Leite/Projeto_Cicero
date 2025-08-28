package com.duende.cicero_app.dto.origin.majorEvent;

import com.duende.cicero_app.model.origin.MajorEventModel;

public record MajorEventResponseDTO (String name) {
    public static MajorEventResponseDTO fromEntity (MajorEventModel majorEvent) {
        return new MajorEventResponseDTO(majorEvent.getName());
    }
}
