package com.duende.cicero_app.service.interfaces.item;

import com.duende.cicero_app.model.item.EquipmentModel;
import org.springframework.stereotype.Component;

@Component("Consumível")
public class ConsumableEquipmentQualityEffect implements EquipmentQualityEffectsStrategy {

    @Override
    public void applyEquipmentQuality(EquipmentModel equipment) {
        equipment.setUsesTotal(1);
        equipment.setUsesCurrent(equipment.getUsesTotal());
    }
}
