package com.duende.cicero_app.controller.infected;

import com.duende.cicero_app.dto.infected.InfectedCreateDTO;
import com.duende.cicero_app.dto.infected.InfectedResponseDTO;
import com.duende.cicero_app.service.infected.InfectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infected")
public class InfectedController {

    private final InfectedService infectedService;

    @Autowired
    public InfectedController (InfectedService infectedService) { this.infectedService = infectedService; }

    @GetMapping
    public ResponseEntity<List<InfectedResponseDTO>> findAll() {
        List<InfectedResponseDTO> infected = infectedService.findAllInfected();
        return ResponseEntity.status(HttpStatus.OK).body(infected);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfectedResponseDTO> findById(@PathVariable Long id) {
        InfectedResponseDTO infected = infectedService.findInfectedById(id);
        return ResponseEntity.status(HttpStatus.OK).body(infected);
    }

    @PostMapping
    public ResponseEntity<InfectedCreateDTO> create(@RequestBody InfectedCreateDTO dto) {
        infectedService.createInfected(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            infectedService.deleteInfected(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Infectado deletado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
