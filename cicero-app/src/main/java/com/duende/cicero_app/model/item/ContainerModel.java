package com.duende.cicero_app.model.item;

import com.duende.cicero_app.model.infected.InfectedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "tb_container")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContainerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Integer totalSize;
    private Integer currentSize;
    private Integer spaciousLevel;

    @OneToMany(mappedBy = "container")
    private List<ContainerEquipmentModel> containerEquipmentList;

    @ManyToOne
    @JoinColumn(name = "infected_id")
    private InfectedModel infected;

    @Transient
    public int getEffectiveCapacity() {
        return totalSize + switch (spaciousLevel) {
            case 1 -> 2;
            case 2 -> 5;
            default -> 0;
        };
    }

}
