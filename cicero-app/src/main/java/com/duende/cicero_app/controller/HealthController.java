package com.duende.cicero_app.controller;

import com.duende.cicero_app.dto.health.HealthCreateDTO;
import com.duende.cicero_app.dto.health.HealthResponseDTO;
import com.duende.cicero_app.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthController {

    private final HealthService healthService;

    @Autowired
    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping
    public ResponseEntity<List<HealthResponseDTO>> findAll() {
        List<HealthResponseDTO> healthBox = healthService.findAllHealths();
        return ResponseEntity.status(HttpStatus.OK).body(healthBox);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthResponseDTO> findById(@PathVariable Long id) {
        HealthResponseDTO healthBox = healthService.findHealthById(id);
        return ResponseEntity.status(HttpStatus.OK).body(healthBox);
    }

    @PostMapping("/{id}")
    public ResponseEntity<HealthResponseDTO> create(@RequestBody HealthCreateDTO dto) {
        HealthResponseDTO response = healthService.createHeatlhBox(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
