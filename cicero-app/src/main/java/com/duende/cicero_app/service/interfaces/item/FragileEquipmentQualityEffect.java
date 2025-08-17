package com.duende.cicero_app.service.interfaces.item;

import com.duende.cicero_app.model.item.EquipmentModel;
import org.springframework.stereotype.Component;

@Component("Frágil")
public class FragileEquipmentQualityEffect implements EquipmentQualityEffectsStrategy {

    @Override
    public void applyEquipmentQuality(EquipmentModel equipment) {

        equipment.setUsesTotal(equipment.getUsesTotal() - 1);
        equipment.setUsesCurrent(equipment.getUsesTotal());

    }

}
