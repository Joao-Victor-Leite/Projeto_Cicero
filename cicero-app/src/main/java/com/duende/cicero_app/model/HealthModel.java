package com.duende.cicero_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name="tb_health")
@Getter
@Setter
public class HealthModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer box;
    private String description;
    private Integer boxSequence;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdData;

    @UpdateTimestamp
    private LocalDateTime updatedData;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "infected", fetch = FetchType.LAZY)
    private Set<InfectedModel> infecteds = new HashSet<>();
}
