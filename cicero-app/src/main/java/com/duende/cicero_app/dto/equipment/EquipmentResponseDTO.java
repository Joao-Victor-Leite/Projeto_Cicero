package com.duende.cicero_app.dto.equipment;

import com.duende.cicero_app.dto.item.ItemResponseDTO;
import com.duende.cicero_app.model.EquipmentModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EquipmentResponseDTO extends ItemResponseDTO {

    private Integer points;

    public static EquipmentResponseDTO fromEntity(EquipmentModel equipment) {

        EquipmentResponseDTO dto = new EquipmentResponseDTO();
        dto.setId(equipment.getId());
        dto.setName(equipment.getName());
        dto.setUsesTotal(equipment.getUsesTotal());
        dto.setUsesCurrent(equipment.getUsesCurrent());
        dto.setPoints(equipment.getPoints());

        return dto;
    }

}
