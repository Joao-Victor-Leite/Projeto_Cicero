package com.duende.cicero_app.model.purpose;

import com.duende.cicero_app.model.infected.InfectedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_personal_purpose")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalPurposeModel extends PurposeModel{

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

}
