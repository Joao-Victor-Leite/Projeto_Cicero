package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.model.infected.InfectedInstinctModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import org.springframework.stereotype.Service;

@Service
public class InfectedHealthAttributeService {

    public void calculateHealth (InfectedModel infected) {

        int attributeScore = getAttributeHealthScore(infected);
        int healthTotal = (attributeScore + 2) * 5;

        infected.setHealthTotal(healthTotal);
        infected.setHealthCurrent(healthTotal);

    }

    private int getAttributeHealthScore (InfectedModel infected) {
        return infected.getInstinctList().stream()
                .filter(i -> i.getInstinct().getName().equalsIgnoreCase(infected.getAttributeHealth().getLabel()))
                .map(InfectedInstinctModel::getScore)
                .findFirst()
                .orElse(0);
    }
}
