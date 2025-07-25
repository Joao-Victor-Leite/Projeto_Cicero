package com.duende.cicero_app.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tb_equipment")
@Getter
@Setter
public class EquipmentModel extends ItemModel{

    private Integer points;

    public EquipmentModel(){}

}
