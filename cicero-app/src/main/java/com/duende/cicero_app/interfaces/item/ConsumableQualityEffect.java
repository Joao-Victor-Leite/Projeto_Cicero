package com.duende.cicero_app.interfaces.item;

import com.duende.cicero_app.interfaces.QualityEffectsStrategy;
import com.duende.cicero_app.model.item.EquipmentModel;
import org.springframework.stereotype.Component;

@Component("Consumível")
public class ConsumableQualityEffect implements QualityEffectsStrategy {

    @Override
    public void apply(EquipmentModel equipment) {
        equipment.setUsesTotal(1);
        equipment.setUsesCurrent(equipment.getUsesTotal());
    }
}
