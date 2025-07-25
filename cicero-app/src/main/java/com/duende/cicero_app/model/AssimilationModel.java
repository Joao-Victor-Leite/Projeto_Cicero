package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="tb_assimilation")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AssimilationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer type;
    private String card;
    private String card_description;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdData;

    public AssimilationModel(){}
}
