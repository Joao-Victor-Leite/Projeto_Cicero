package com.duende.cicero_app.dto.infected;

import com.duende.cicero_app.model.infected.InfectedModel;

import java.util.List;

public record InfectedResponseDTO(
        String name,
        Integer healthTotal,
        Integer healthCurrent,
        Integer determinationTotal,
        Integer determinationCurrent,
        Integer assimilationTotal,
        Integer assimilationCurrent,
        Boolean susceptible,
        List<GenerationDTO> generation,
        List<MajorEventDTO> majorEvent,
        List<OccupationDTO> occupation,
        List<InfectedInstinctDTO> instinct
) {

    public record GenerationDTO (String name, String description, Integer scoreTotal,Integer scoreCurrent) {}
    public record MajorEventDTO (String name, Integer scoreTotal,Integer scoreCurrent) {}
    public record OccupationDTO (String name, Integer scoreTotal,Integer scoreCurrent) {}
    public record InfectedInstinctDTO (String name, Integer score) {}

    public static InfectedResponseDTO fromEntity (InfectedModel infected) {
        return new InfectedResponseDTO(
                infected.getName(),
                infected.getHealthCurrent(),
                infected.getHealthTotal(),
                infected.getDeterminationCurrent(),
                infected.getDeterminationTotal(),
                infected.getAssimilationCurrent(),
                infected.getAssimilationTotal(),
                infected.getSusceptible(),

                infected.getGenerationList().stream().map(g ->
                        new GenerationDTO(
                                g.getGeneration().getName(),
                                g.getDescription(),
                                g.getScoreTotal(),
                                g.getScoreCurrent()
                        )
                ).toList(),

                infected.getMajorEventList().stream().map(m ->
                        new MajorEventDTO(
                                m.getMajorEvent().getName(),
                                m.getScoreTotal(),
                                m.getScoreCurrent()
                        )
                ).toList(),

                infected.getOccupationList().stream().map(o ->
                        new OccupationDTO(
                                o.getOccupation().getName(),
                                o.getScoreTotal(),
                                o.getScoreCurrent()
                        )
                ).toList(),

                infected.getInstinctList().stream().map(i ->
                        new InfectedInstinctDTO(
                                i.getInstinct().getName(),
                                i.getScore()
                        )
                ).toList()
        );
    }
}
