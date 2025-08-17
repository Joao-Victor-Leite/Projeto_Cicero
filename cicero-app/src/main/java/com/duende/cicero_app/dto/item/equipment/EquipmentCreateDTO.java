package com.duende.cicero_app.dto.item.equipment;

import java.util.Set;

public record EquipmentCreateDTO(
        String name,
        Integer points,
        Integer usesTotal,
        Integer size,
        Boolean broken,
        Set<Long> qualityIds
) {
}
