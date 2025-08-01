package com.duende.cicero_app.dto.item;

import com.duende.cicero_app.model.ItemModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDTO {

    private Long id;
    private String name;
    private Integer usesTotal;
    private Integer usesCurrent;
    private Integer size;

    public static ItemResponseDTO fromEntity(ItemModel item) {

        ItemResponseDTO dto = new ItemResponseDTO();
        dto.id = item.getId();
        dto.name = item.getName();
        dto.usesTotal = item.getUsesTotal();
        dto.usesCurrent = item.getUsesCurrent();
        dto.size = item.getSize();

        return dto;
    }

}
