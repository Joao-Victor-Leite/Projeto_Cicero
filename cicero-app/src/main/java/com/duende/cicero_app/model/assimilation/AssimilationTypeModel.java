package com.duende.cicero_app.model.assimilation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="tb_assimilation_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssimilationTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type")
    private List<AssimilationCardModel> cards = new ArrayList<>();

}
