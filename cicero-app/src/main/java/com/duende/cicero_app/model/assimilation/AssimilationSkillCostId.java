package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssimilationSkillCostId implements Serializable {

    private Long assimilationCardSkillId;
    private Long assimilationCostTypeId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AssimilationSkillCostId that)) return false;
        return Objects.equals(assimilationCardSkillId, that.assimilationCardSkillId) &&
                Objects.equals(assimilationCostTypeId, that.assimilationCostTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assimilationCardSkillId, assimilationCostTypeId);
    }

}
