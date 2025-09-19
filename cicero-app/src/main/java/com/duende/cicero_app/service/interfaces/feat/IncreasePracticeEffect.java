package com.duende.cicero_app.service.interfaces.feat;

import com.duende.cicero_app.model.FeatModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import org.springframework.stereotype.Component;

@Component("Aumentar Pratica")
public class IncreasePracticeEffect implements FeatApplier{

    @Override
    public boolean supports (FeatModel feat) {
        return feat.getName().startsWith("Aumentar Prática");
    }

    @Override
    public void apply(InfectedModel infected, FeatModel feat, Long practiceId) {
        var practice = infected.getPracticeList().stream()
                .filter(k -> k.getId().getPracticeId().equals(practiceId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Prática não encontradoa"));

        int increase = feat.getCost();
        int newValue = practice.getScore() + increase;

        if (newValue > 3) {
            throw new IllegalArgumentException("Não é possível aumentar além de 3 neste conhecimento");
        }

        practice.setScore(newValue);
        infected.getFeats().add(feat);

    }

}
