package com.duende.cicero_app.dto.attribute.knowledge;

import com.duende.cicero_app.model.attribute.KnowledgeModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KnowledgeResponseDTO {

    private Long id;
    private String name;

    public static KnowledgeResponseDTO fromEntity(KnowledgeModel knowledge) {

        KnowledgeResponseDTO dto = new KnowledgeResponseDTO();
        dto.id = knowledge.getId();
        dto.name = knowledge.getName();

        return dto;
    }
}
