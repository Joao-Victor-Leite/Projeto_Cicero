package com.duende.cicero_app.dto.attribute.practice;

import com.duende.cicero_app.model.attribute.PracticeModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PracticeResponseDTO {

    private Long id;
    private String name;

    public static PracticeResponseDTO fromEntity(PracticeModel practice) {

        PracticeResponseDTO dto = new PracticeResponseDTO();
        dto.id = practice.getId();
        dto.name = practice.getName();

        return dto;
    }
}
