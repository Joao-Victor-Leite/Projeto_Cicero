package com.duende.cicero_app.controller.attributes;

import com.duende.cicero_app.dto.attribute.instinct.InstinctResponseDTO;
import com.duende.cicero_app.service.attribute.InstinctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instinct")
public class InstinctController {

    private final InstinctService instinctService;

    @Autowired
    public InstinctController(InstinctService instinctService) { this.instinctService = instinctService; }

    @GetMapping
    public ResponseEntity<List<InstinctResponseDTO>> findAll() {
        List<InstinctResponseDTO> instinct = instinctService.findAllInstincts();
        return ResponseEntity.status(HttpStatus.OK).body(instinct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstinctResponseDTO> findById(@PathVariable Long id) {
        InstinctResponseDTO instinct = instinctService.findInstinctById(id);
        return ResponseEntity.status(HttpStatus.OK).body(instinct);
    }
}
