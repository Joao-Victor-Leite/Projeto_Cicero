package com.duende.cicero_app.service.interfaces.item;

import com.duende.cicero_app.model.item.ContainerModel;
import org.springframework.stereotype.Component;

@Component("Espaçoso")
public class SpaciousQualityEffect implements ContainerQualityEffectsStrategy {

    @Override
    public void applyContainerQuality(ContainerModel container) {
        if (container.getSpaciousLevel() < 2) {
            container.setSpaciousLevel(container.getSpaciousLevel() + 1);
        }
    }
}
