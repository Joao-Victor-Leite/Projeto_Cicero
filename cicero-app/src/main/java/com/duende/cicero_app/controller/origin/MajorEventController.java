package com.duende.cicero_app.controller.origin;

import com.duende.cicero_app.dto.origin.majorEvent.MajorEventCreateDTO;
import com.duende.cicero_app.dto.origin.majorEvent.MajorEventResponseDTO;
import com.duende.cicero_app.service.origin.MajorEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/majorEvent")
public class MajorEventController {

    private final MajorEventService majorEventService;

    @Autowired
    public MajorEventController(MajorEventService majorEventService) {
        this.majorEventService = majorEventService;
    }

    @GetMapping
    public ResponseEntity<List<MajorEventResponseDTO>> findAll() {
        List<MajorEventResponseDTO> majorEvent = majorEventService.findAllMajorEvents();
        return ResponseEntity.status(HttpStatus.OK).body(majorEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MajorEventResponseDTO> findById(@PathVariable Short id) {
        MajorEventResponseDTO majorEvent = majorEventService.findMajorEventById(id);
        return ResponseEntity.status(HttpStatus.OK).body(majorEvent);
    }

    @PostMapping
    public ResponseEntity<MajorEventResponseDTO> create(@RequestBody MajorEventCreateDTO dto) {
        majorEventService.createMajorEvent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MajorEventResponseDTO> update(@PathVariable Short id,
                                                        @RequestBody MajorEventCreateDTO dto) {
        majorEventService.updateMajorEvent(id, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Short id) {
        try {
            majorEventService.deleteMajorEvent(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Evento marcante deletado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
