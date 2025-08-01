package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="tb_item")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer usesTotal = 4;
    private Integer usesCurrent;
    private Integer size;

    public ItemModel() {}
}
