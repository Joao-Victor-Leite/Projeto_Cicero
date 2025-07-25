package com.duende.cicero_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name="tb_assimilation_skill")
@Getter
@Setter
public class AssimilationSkillModel extends AssimilationModel{

    private String cost;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "tb_infected_assimilation_skill",
            joinColumns = @JoinColumn(name = "infected_id"),
            inverseJoinColumns = @JoinColumn(name = "assimilation_skill_id")
    )
    private Set<InfectedModel> infecteds = new HashSet<>();
}
