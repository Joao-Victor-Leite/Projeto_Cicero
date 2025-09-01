package com.duende.cicero_app.model.attribute;

import com.duende.cicero_app.model.infected.InfectedPracticeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_practice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PracticeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "practice")
    private List<InfectedPracticeModel> practiceList = new ArrayList<>();

}
