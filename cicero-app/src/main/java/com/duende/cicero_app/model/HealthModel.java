package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="tb_health")
public class HealthModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private Integer box;

    @Column(unique = true, nullable = false)
    private String description;

    @Column(unique = true, nullable = false)
    private Integer order;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdData;

    @UpdateTimestamp
    private LocalDateTime updatedData;
}
