package com.duende.cicero_app.dto.user;

public record UserCreateDTO(
        String name,
        String email,
        String password
) {
}
