package com.duende.cicero_app.model.purpose;

import com.duende.cicero_app.model.infected.InfectedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "tb_relational_purpose")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelationalPurposeModel extends PurposeModel{

    @ManyToMany(mappedBy = "relationalPurposes")
    private Set<InfectedModel> infected;

}
