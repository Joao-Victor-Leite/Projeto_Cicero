package com.duende.cicero_app.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tb_assimilation_skill")
@Getter
@Setter
public class AssimilationSkillModel extends AssimilationModel{

    private String cost;
    private String description;
}
