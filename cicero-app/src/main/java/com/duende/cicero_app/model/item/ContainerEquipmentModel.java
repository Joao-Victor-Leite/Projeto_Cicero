package com.duende.cicero_app.model.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_container_equipment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContainerEquipmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private ContainerModel container;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private EquipmentModel equipment;

    private Integer quantity;

}
