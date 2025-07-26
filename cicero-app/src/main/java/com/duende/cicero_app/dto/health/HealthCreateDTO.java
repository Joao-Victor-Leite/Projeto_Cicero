package com.duende.cicero_app.dto.health;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthCreateDTO {

    private Long id;
    private Integer box;
    private String description;
    private Integer boxSequence;

}
