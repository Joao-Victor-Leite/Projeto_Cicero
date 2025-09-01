package com.duende.cicero_app.model.origin;

import com.duende.cicero_app.model.infected.InfectedOccupationModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_occupation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OccupationModel extends OriginModel{

    @OneToMany(mappedBy = "occupation")
    private List<InfectedOccupationModel> occupationList = new ArrayList<>();

}
