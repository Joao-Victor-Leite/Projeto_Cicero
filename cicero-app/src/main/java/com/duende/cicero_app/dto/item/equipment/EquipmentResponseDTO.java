package com.duende.cicero_app.dto.item.equipment;

import com.duende.cicero_app.dto.item.quality.QualityResponseDTO;
import com.duende.cicero_app.model.item.EquipmentModel;

import java.util.Set;
import java.util.stream.Collectors;

public record EquipmentResponseDTO(
        String name,
        Integer points,
        Integer usesTotal,
        Integer usesCurrent,
        Integer size,
        Boolean broken,
        Set<QualityResponseDTO> qualities
) {
    public static EquipmentResponseDTO fromEntity(EquipmentModel equipment) {
        return new EquipmentResponseDTO(
                equipment.getName(),
                equipment.getPoints(),
                equipment.getUsesTotal(),
                equipment.getUsesCurrent(),
                equipment.getSize(),
                equipment.getBroken(),
                equipment.getQualities() != null ?
                        equipment.getQualities()
                                .stream()
                                .map(QualityResponseDTO::fromEntity)
                                .collect(Collectors.toSet())
                        : Set.of()
        );
    }
}
