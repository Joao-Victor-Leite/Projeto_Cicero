package com.duende.cicero_app.service.infected.attribute;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AttributeDistributionConfig {

    private final Map<AttributeDistributionType, List<Integer>> distributionMap = new HashMap<>();

    public AttributeDistributionConfig() {
        distributionMap.put(AttributeDistributionType.GENERALISTA, Arrays.asList(2,2,2,1,1,1));
        distributionMap.put(AttributeDistributionType.ESPECIALISTA, Arrays.asList(3,2,2,1,1,1));
    }

    public List<Integer> getDistribution (AttributeDistributionType type) {
        return distributionMap.get(type);
    }

}
