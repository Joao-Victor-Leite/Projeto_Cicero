package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_assimilation_skill_cost")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssimilationSkillCostModel {

    @EmbeddedId
    private AssimilationSkillCostId id = new AssimilationSkillCostId();

    @ManyToOne
    @MapsId("assimilationCardSkillId")
    @JoinColumn(name = "assimilation_card_skill_id")
    private AssimilationCardModel assimilationCard;

    @ManyToOne
    @MapsId("assimilationCostTypeId")
    @JoinColumn(name = "assimilation_cost_type_id")
    private AssimilationCostTypeModel assimilationCostType;

    private Integer quantity;

}
