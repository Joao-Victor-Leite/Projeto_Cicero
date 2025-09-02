package com.duende.cicero_app.dto.infected;

import com.duende.cicero_app.model.infected.InfectedInstinctModel;

public record InfectedInstinctResponseDTO(
        Long infectedId,
        Long instinctId,
        String instinctName,
        Integer score
) {

    public static InfectedInstinctResponseDTO fromEntity (InfectedInstinctModel entity) {
        return new InfectedInstinctResponseDTO(
                entity.getInfected().getId(),
                entity.getInstinct().getId(),
                entity.getInstinct().getName(),
                entity.getScore()
        );
    }
}
