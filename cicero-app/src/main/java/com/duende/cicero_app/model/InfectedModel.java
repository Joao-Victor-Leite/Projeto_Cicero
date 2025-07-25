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

@Entity(name = "tb_infected")
@Getter
@Setter
public class InfectedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "health_id")
    private HealthModel health;

    private String name;
    private Integer healthTotal;
    private Integer healthCurrent;
    private Integer determination;
    private Integer determinationCurrent;
    private Integer assimilation;
    private Integer assimilationCurrent;
    private Integer bulkTotal;
    private Integer bulkCurrent;
    private Boolean susceptible;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdData;

    @UpdateTimestamp
    private LocalDateTime updatedData;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "infecteds", fetch = FetchType.LAZY)
    private Set<AssimilationSkillModel> assimilationSkills = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "infected", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InfectedInstinctModel> infectedInstincts = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "infected", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InfectedKnowledgeModel> infectedKnowledges = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "infected", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InfectedPracticeModel> infectedPratices = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "infected", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InfectedOriginModel> infectedOrigins = new HashSet<>();
}
