package com.duende.cicero_app.model.origin;

import com.duende.cicero_app.model.infected.InfectedGenerationModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_generation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerationModel extends OriginModel{

    @OneToMany(mappedBy = "generation")
    private List<InfectedGenerationModel> generationList = new ArrayList<>();

}
