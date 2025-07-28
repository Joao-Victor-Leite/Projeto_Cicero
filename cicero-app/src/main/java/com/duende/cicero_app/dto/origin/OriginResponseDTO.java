package com.duende.cicero_app.dto.origin;

import com.duende.cicero_app.model.OriginModel;
import lombok.Getter;

@Getter
public class OriginResponseDTO {

    private Long id;
    private String name;

    public static OriginResponseDTO fromEntity(OriginModel origin) {
        OriginResponseDTO dto = new OriginResponseDTO();
        dto.id = origin.getId();
        dto.name = origin.getName();
        return dto;
    }
}
