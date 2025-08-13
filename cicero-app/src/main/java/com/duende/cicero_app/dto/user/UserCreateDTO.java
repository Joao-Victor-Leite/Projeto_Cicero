package com.duende.cicero_app.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password
) {}
