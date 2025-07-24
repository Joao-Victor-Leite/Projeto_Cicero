package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="tb_item")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    private Integer totalUses;
    private Integer actualUses;
    private Integer size;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdData;

    @UpdateTimestamp
    private LocalDateTime updatedData;
}
