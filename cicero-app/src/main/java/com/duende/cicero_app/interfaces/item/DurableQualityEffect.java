package com.duende.cicero_app.interfaces.item;

import com.duende.cicero_app.model.item.EquipmentModel;
import org.springframework.stereotype.Component;

@Component("Durável")
public class DurableQualityEffect implemets QualityEffectsStrategy {

    @Override
    public void apply (EquipmentModel equipment) {

        boolean isConsumable = equipment.getQuality()
                .stream()
                .anyMatch(q -> "Consumível".equalsIgnoreCase(q.getName()));

        if (isConsumable) {
            throw new IllegalArgumentException("Não é possível aplicar a qualidade 'Durável' em um item Consumível");
        }

        long countDurable = equipment.getQuality()
                .stream()
                .filter(q -> "Durável".equalsIgnoreCase(q.getName()))
                .count();

        int bonus = (countDurable >= 2) ? 5:2;

        equipment.setUsesTotal(equipment.getUsesTotal() + bonus);
        equipment.setUsesCurrent(equipment.getUsesTotal());

    }
}
