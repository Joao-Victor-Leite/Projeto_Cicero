package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="tb_assimilation_card")
@Getter
@Setter
public class AssimilationCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private AssimilationTypeModel type;

    private String name;
    private String card;

    @OneToMany(mappedBy = "card")
    private List<AssimilationSkillModel> skills = new ArrayList<>();

    public AssimilationCardModel() {}
}
