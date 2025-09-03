package com.duende.cicero_app.model.infected;

import lombok.Getter;

@Getter
public enum AttributeHealth {
    POTENCIA("Potência"),
    RESOLUCAO("Resolução");

    private final String label;

    AttributeHealth(String label) {
        this.label = label;
    }

}
