package com.duende.cicero_app.service.container;

import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.model.item.ContainerModel;
import com.duende.cicero_app.model.item.ContainerType;
import com.duende.cicero_app.repository.item.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;

    @Autowired
    public ContainerService (ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public void createDefaultContainers (InfectedModel infected) {

        ContainerModel personal = new ContainerModel();
        personal.setType(ContainerType.PERSONAL);
        personal.setTotalSize(2);
        personal.setCurrentSize(0);
        personal.setInfected(infected);

        ContainerModel backpack = new ContainerModel();
        backpack.setType(ContainerType.BACKPACK);
        backpack.setTotalSize(6);
        backpack.setCurrentSize(0);
        backpack.setInfected(infected);

        containerRepository.saveAll(List.of(personal, backpack));
        infected.setContainerList(List.of(personal, backpack));

    }
}
