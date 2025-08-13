package com.duende.cicero_app.dto.user;

import com.duende.cicero_app.model.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;


public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        LocalDateTime updatedData
) {

    public static UserResponseDTO fromEntity(UserModel user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUpdatedData()
        );
    }

}
