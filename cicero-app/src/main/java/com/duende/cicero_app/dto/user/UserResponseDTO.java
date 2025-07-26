package com.duende.cicero_app.dto.user;

import com.duende.cicero_app.model.UserModel;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public static UserResponseDTO fromEntity(UserModel user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.id = user.getId();
        dto.name = user.getName();
        dto.email = user.getEmail();
        dto.createdAt = user.getCreatedData();
        return dto;
    }
}
