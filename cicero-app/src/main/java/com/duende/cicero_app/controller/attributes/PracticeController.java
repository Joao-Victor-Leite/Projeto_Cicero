package com.duende.cicero_app.controller.attributes;

import com.duende.cicero_app.dto.attribute.practice.PracticeResponseDTO;
import com.duende.cicero_app.service.attribute.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/practice")
public class PracticeController {

    private final PracticeService practiceService;

    @Autowired
    public PracticeController(PracticeService practiceService) { this.practiceService = practiceService; }

    @GetMapping
    public ResponseEntity<List<PracticeResponseDTO>> findAll() {
        List<PracticeResponseDTO> practice = practiceService.findAllPractice();
        return ResponseEntity.status(HttpStatus.OK).body(practice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PracticeResponseDTO> findById(@PathVariable Long id) {
        PracticeResponseDTO practice = practiceService.findPracticeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(practice);
    }


}
