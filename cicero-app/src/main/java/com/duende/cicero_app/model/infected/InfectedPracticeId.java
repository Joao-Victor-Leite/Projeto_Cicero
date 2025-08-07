package com.duende.cicero_app.model.infected;

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
public class InfectedPracticeId implements Serializable {

    private Long infectedId;
    private Long practiceId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof InfectedPracticeId that)) return false;
        return Objects.equals(infectedId, that.infectedId) &&
                Objects.equals(practiceId, that.practiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infectedId, practiceId);
    }

}
