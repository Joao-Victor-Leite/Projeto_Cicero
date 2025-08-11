package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="tb_assimilation_skill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssimilationSkillModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private AssimilationCardModel card;

    @Lob
    private String description;
    private String prerequisite;

    @OneToMany(mappedBy = "assimilationSkill")
    private List<AssimilationSkillCostModel> skillCost;

}
