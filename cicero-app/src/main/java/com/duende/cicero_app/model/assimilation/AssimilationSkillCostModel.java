package com.duende.cicero_app.model.assimilation;

import com.duende.cicero_app.model.infected.InfectedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "tb_assimilation_skill_cost")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssimilationSkillCostModel {

    @EmbeddedId
    private AssimilationSkillCostId id = new AssimilationSkillCostId();

    @ManyToOne
    @MapsId("assimilationSkillId")
    @JoinColumn(name = "assimilation_skill_id")
    private AssimilationSkillModel assimilationSkill;

    @ManyToOne
    @MapsId("assimilationCostTypeId")
    @JoinColumn(name = "assimilation_cost_type_id")
    private AssimilationCostTypeModel assimilationCostType;

    private Integer quantity;

    @ManyToMany(mappedBy = "skillCost")
    private List<InfectedModel> infected;

}
