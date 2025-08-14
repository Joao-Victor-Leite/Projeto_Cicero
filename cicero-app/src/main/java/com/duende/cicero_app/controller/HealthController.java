package com.duende.cicero_app.controller;

import com.duende.cicero_app.dto.health.HealthResponseDTO;
import com.duende.cicero_app.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<HealthResponseDTO> healths = healthService.findAllHealths();
        return ResponseEntity.status(HttpStatus.OK).body(healths);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthResponseDTO> findById(@PathVariable Long id) {
        HealthResponseDTO health = healthService.findHealthById(id);
        return ResponseEntity.status(HttpStatus.OK).body(health);
    }

}
