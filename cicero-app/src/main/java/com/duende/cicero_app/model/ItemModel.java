package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="tb_item")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer totalUses;
    private Integer actualUses;
    private Integer size;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdData;

    @UpdateTimestamp
    private LocalDateTime updatedData;

    public ItemModel(){}
}
