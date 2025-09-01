package com.duende.cicero_app.model.origin;

import com.duende.cicero_app.model.infected.InfectedMajorEventModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_major_event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MajorEventModel extends OriginModel{

    @OneToMany(mappedBy = "majorEvent")
    private List<InfectedMajorEventModel> majorEventList = new ArrayList<>();

}
