package com.duende.cicero_app.model.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "tb_equipment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer points;
    private Integer usesTotal;
    private Integer usesCurrent;
    private Integer size;
    private Boolean broken;

    @OneToMany(mappedBy = "equipment")
    private List<ContainerEquipmentModel> containerEquipmentList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tb_equipment_quality",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "quality_id")
    )
    private Set<QualityModel> qualities = new HashSet<>();

}
