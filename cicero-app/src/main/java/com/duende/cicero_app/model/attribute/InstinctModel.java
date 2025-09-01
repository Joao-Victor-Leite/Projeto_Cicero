package com.duende.cicero_app.model.attribute;

import com.duende.cicero_app.model.infected.InfectedInstinctModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_instinct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstinctModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "instinct")
    private List<InfectedInstinctModel> instinctList = new ArrayList<>();

}
