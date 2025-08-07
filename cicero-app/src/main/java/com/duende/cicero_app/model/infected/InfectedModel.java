package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.FeatModel;
import com.duende.cicero_app.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity(name="tb_infected")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfectedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    private String name;
    private Integer healthTotal;
    private Integer healthCurrent;
    private Integer determinationTotal;
    private Integer determinationCurrent;
    private Integer assimilationTotal;
    private Integer assimilationCurrent;

    // pensar em como gerenciar a carga do personagem

    private Boolean susceptible = Boolean.FALSE;

    @OneToMany(mappedBy = "infected")
    private List<InfectedInstinctModel> instinctList;

    @OneToMany(mappedBy = "infected")
    private List<InfectedPracticeModel> practiceList;

    @OneToMany(mappedBy = "infected")
    private List<InfectedKnowledgeModel> knowledgeList;

    @OneToMany(mappedBy = "infected")
    private List<InfectedGenerationModel> generationList;

    @OneToMany(mappedBy = "infected")
    private List<InfectedMajorEventModel> majorEventList;

    @OneToMany(mappedBy = "infected")
    private List<InfectedOccupationModel> occupationList;

    @ManyToMany
    @JoinTable(
            name = "infected_feat",
            joinColumns = @JoinColumn(name = "infected_id"),
            inverseJoinColumns = @JoinColumn(name = "feat_id")
    )
    private Set<FeatModel> feats;

}
