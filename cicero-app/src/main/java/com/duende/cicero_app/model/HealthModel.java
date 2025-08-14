package com.duende.cicero_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tb_health")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer box;
    private String description;

}
