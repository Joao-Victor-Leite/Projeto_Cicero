package com.duende.cicero_app.dto.user;

import com.duende.cicero_app.dto.infected.InfectedResponseDTO;
import com.duende.cicero_app.model.UserModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        LocalDateTime createdData,
        LocalDateTime updatedData,
        List<InfectedResponseDTO> infected
) {

    public static UserResponseDTO fromEntity(UserModel user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedData(),
                user.getUpdatedData(),
                user.getInfected() != null ?
                        user.getInfected()
                                .stream()
                                .map(InfectedResponseDTO::fromEntity)
                                .collect(Collectors.toList())
                        : List.of()
        );
    }

}
