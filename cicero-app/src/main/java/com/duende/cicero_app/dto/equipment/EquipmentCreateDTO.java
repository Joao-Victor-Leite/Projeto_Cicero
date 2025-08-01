package com.duende.cicero_app.dto.equipment;

import com.duende.cicero_app.dto.item.ItemCreateDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EquipmentCreateDTO extends ItemCreateDTO {

    private Integer points;

}
