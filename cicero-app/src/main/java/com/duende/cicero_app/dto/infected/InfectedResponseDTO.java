package com.duende.cicero_app.dto.infected;

import com.duende.cicero_app.model.infected.InfectedModel;

public record InfectedResponseDTO(
        String name
) {
    public static InfectedResponseDTO fromEntity (InfectedModel infected) {
        return new InfectedResponseDTO(infected.getName());
    }
}
