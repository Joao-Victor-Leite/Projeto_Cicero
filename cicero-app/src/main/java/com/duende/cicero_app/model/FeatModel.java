package com.duende.cicero_app.model;

import com.duende.cicero_app.model.infected.InfectedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "tb_feat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;
    private Integer cost;

    @Lob
    private String description;

    @ManyToMany(mappedBy = "feats")
    private Set<InfectedModel> infected = new HashSet<>();

}
