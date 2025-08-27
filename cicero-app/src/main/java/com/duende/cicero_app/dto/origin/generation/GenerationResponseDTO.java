package com.duende.cicero_app.dto.origin.generation;

import com.duende.cicero_app.model.origin.GenerationModel;

public record GenerationResponseDTO (String name) {
    public static GenerationResponseDTO fromEntity (GenerationModel generation) {
        return new GenerationResponseDTO(generation.getName());
    }
}
