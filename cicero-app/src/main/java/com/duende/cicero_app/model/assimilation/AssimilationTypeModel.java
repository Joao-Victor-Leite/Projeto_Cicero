package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="tb_assimilation_type")
@Getter
@Setter
public class AssimilationTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<AssimilationModel> assimilation = new ArrayList<>();

    public AssimilationTypeModel () {}
}
