package com.duende.cicero_app.dto.feat;

import com.duende.cicero_app.model.FeatModel;
import lombok.Getter;

@Getter
public class FeatResponseDTO {
    // user records
    // usar uma biblioteca de mapeamento

    private Long id;
    private String name;
    private Integer cost;
    private String description;

    public static FeatResponseDTO fromEntity(FeatModel feat) {

        FeatResponseDTO dto = new FeatResponseDTO();
        dto.id = feat.getId();
        dto.name = feat.getName();
        dto.cost = feat.getCost();
        dto.description = feat.getDescription();

        return dto;
    }
}
