package com.duende.cicero_app.service.interfaces.feat;

import com.duende.cicero_app.model.FeatModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import org.springframework.stereotype.Component;

@Component("Aumentar Conhecimento")
public class IncreaseKnowledgeEffect implements FeatApplier {

    @Override
    public boolean supports (FeatModel feat) {
        return feat.getName().startsWith("Aumentar Conhecimento");
    }

    @Override
    public void apply(InfectedModel infected, FeatModel feat, Long knowledgeId) {
        var knowledge = infected.getKnowledgeList().stream()
                .filter(k -> k.getId().getKnowledgeId().equals(knowledgeId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conhecimento não encontrado"));

        int increase = feat.getCost();
        int newValue = knowledge.getScore() + increase;

        if (newValue > 3) {
            throw new IllegalArgumentException("Não é possível aumentar além de 3 neste conhecimento");
        }

        knowledge.setScore(newValue);
        infected.getFeats().add(feat);

    }

}
