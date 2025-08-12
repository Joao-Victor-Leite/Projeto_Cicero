package com.duende.cicero_app.model.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "tb_quality")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QualityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cost;
    private Integer category;
    private String name;

    @Lob
    private String description;

    @ManyToMany(mappedBy = "quality")
    private Set<EquipmentModel> equipment;

}
