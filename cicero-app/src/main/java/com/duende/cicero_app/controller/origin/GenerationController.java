package com.duende.cicero_app.controller.origin;

import com.duende.cicero_app.dto.origin.generation.GenerationResponseDTO;
import com.duende.cicero_app.service.origin.GenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generation")
public class GenerationController {

    private final GenerationService generationService;

    @Autowired
    public GenerationController(GenerationService generationService) {
        this.generationService = generationService;
    }

    @GetMapping
    public ResponseEntity<List<GenerationResponseDTO>> findAll() {
        List<GenerationResponseDTO> generation = generationService.findAllGeneration();
        return ResponseEntity.status(HttpStatus.OK).body(generation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenerationResponseDTO> findById(@PathVariable Short id) {
        GenerationResponseDTO generation = generationService.findGenerationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(generation);
    }

}
