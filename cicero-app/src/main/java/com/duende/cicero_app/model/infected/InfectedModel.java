package com.duende.cicero_app.model.infected;

import com.duende.cicero_app.model.EquipmentModel;
import com.duende.cicero_app.model.FeatModel;
import com.duende.cicero_app.model.assimilation.AssimilationSkillCostModel;
import com.duende.cicero_app.model.purpose.PersonalPurposeModel;
import com.duende.cicero_app.model.UserModel;
import com.duende.cicero_app.model.purpose.RelationalPurposeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Locale;
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

    @OneToMany
    private List<PersonalPurposeModel> purposeModelList;

    @ManyToMany
    @JoinTable(
            name = "infected_feat",
            joinColumns = @JoinColumn(name = "infected_id"),
            inverseJoinColumns = @JoinColumn(name = "feat_id")
    )
    private Set<FeatModel> feats;

    @ManyToMany
    @JoinTable(
            name = "infected_relational_purpose",
            joinColumns = @JoinColumn(name = "infected_id"),
            inverseJoinColumns = @JoinColumn(name = "relational_purpose_id")
    )
    private Set<RelationalPurposeModel> relationalPurposes;

    @ManyToMany
    @JoinTable(
            name = "infected_equipment",
            joinColumns = @JoinColumn(name = "infected_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private Set<EquipmentModel> equipment;

    @ManyToMany
    @JoinTable(
            name = "tb_infected_assimilation",
            joinColumns = @JoinColumn(name = "infected_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "assimilation_skill_id"),
                    @JoinColumn(name = "assimilation_cost_type_id")
            }
    )
    private List<AssimilationSkillCostModel> skillCost;

}
