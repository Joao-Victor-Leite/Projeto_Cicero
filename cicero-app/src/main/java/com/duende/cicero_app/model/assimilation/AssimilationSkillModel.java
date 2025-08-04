package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tb_assimilation_skill")
@Getter
@Setter
public class AssimilationSkillModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private AssimilationCardModel card;

    private String description;
    private String prerequisite;

    public AssimilationSkillModel() {}
}
