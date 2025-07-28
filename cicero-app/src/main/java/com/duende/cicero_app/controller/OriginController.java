package com.duende.cicero_app.controller;

import com.duende.cicero_app.dto.origin.OriginResponseDTO;
import com.duende.cicero_app.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/origin")
public class OriginController {

    private final OriginService originService;

    @Autowired
    public OriginController(OriginService originService) {
        this.originService = originService;
    }

    @GetMapping
    public ResponseEntity<List<OriginResponseDTO>> findAll() {
        List<OriginResponseDTO> origins = originService.findAllOrigins();
        return ResponseEntity.status(HttpStatus.OK).body(origins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OriginResponseDTO> findById(@PathVariable Long id) {
        OriginResponseDTO origin = originService.findOriginById(id);
        return ResponseEntity.status(HttpStatus.OK).body(origin);
    }
}
