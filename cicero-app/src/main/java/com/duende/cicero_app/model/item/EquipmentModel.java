package com.duende.cicero_app.model.item;

import com.duende.cicero_app.model.infected.InfectedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer usesTotal = 4;
    private Integer usesCurrent = usesTotal;
    private Integer size = 1;

    @ManyToMany
    @JoinTable(
            name = "tb_equipment_quality",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "quality_id")
    )
    private Set<QualityModel> quality;

    @ManyToMany(mappedBy = "equipment")
    private Set<InfectedModel> infected;

}
