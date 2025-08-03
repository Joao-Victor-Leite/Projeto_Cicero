package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tb_assimilation")
@Getter
@Setter
public class AssimilationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private AssimilationTypeModel type;

    private String name;
    private String card;

    public AssimilationModel() {}
}
