package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_assimilation_cost_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssimilationCostTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "assimilationCostType")
    private List<AssimilationSkillCostModel> skillCost = new ArrayList<>();

}
