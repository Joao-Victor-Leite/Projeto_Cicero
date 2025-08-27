package com.duende.cicero_app.service.infected;

import com.duende.cicero_app.model.infected.InfectedMajorEventModel;
import com.duende.cicero_app.model.infected.InfectedModel;
import com.duende.cicero_app.model.origin.MajorEventModel;
import com.duende.cicero_app.repository.infected.InfectedMajorEventRepository;
import com.duende.cicero_app.repository.origin.MajorEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class InfectedMajorEventService {

    private final MajorEventRepository majorEventRepository;
    private final InfectedMajorEventRepository infectedMajorEventRepository;

    @Autowired
    public InfectedMajorEventService (MajorEventRepository majorEventRepository,
                                      InfectedMajorEventRepository infectedMajorEventRepository) {
        this.majorEventRepository = majorEventRepository;
        this.infectedMajorEventRepository = infectedMajorEventRepository;
    }

    public void linkMajorEvent (InfectedModel infected, short majorEventId) {

        MajorEventModel majorEvent = majorEventRepository.findById(majorEventId)
                .orElseThrow(() -> new NoSuchElementException("Evento marcante não encontrado"));

        InfectedMajorEventModel infectedMajorEvent = new InfectedMajorEventModel();
        infectedMajorEvent.setInfected(infected);
        infectedMajorEvent.setMajorEvent(majorEvent);
        infectedMajorEvent.setScoreTotal(1);
        infectedMajorEvent.setScoreCurrent(infectedMajorEvent.getScoreTotal());

        infectedMajorEventRepository.save(infectedMajorEvent);

    }
}
