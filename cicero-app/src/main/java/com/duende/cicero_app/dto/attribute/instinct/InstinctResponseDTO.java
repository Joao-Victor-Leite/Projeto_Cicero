package com.duende.cicero_app.dto.attribute.instinct;

import com.duende.cicero_app.model.attribute.InstinctModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstinctResponseDTO {

    private Long id;
    private String name;

    public static InstinctResponseDTO fromEntity(InstinctModel instinct) {

        InstinctResponseDTO dto = new InstinctResponseDTO();
        dto.id = instinct.getId();
        dto.name = instinct.getName();

        return dto;
    }
}
