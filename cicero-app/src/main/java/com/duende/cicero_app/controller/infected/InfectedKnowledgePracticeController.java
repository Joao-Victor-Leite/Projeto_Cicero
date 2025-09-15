package com.duende.cicero_app.controller.infected;

import com.duende.cicero_app.dto.infected.InfectedKnowledgePracticeDistributionDTO;
import com.duende.cicero_app.dto.infected.InfectedKnowledgePracticeResponseDTO;
import com.duende.cicero_app.service.infected.InfectedKnowledgePracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infected-knowledge-practice")
public class InfectedKnowledgePracticeController {

    private final InfectedKnowledgePracticeService infectedKnowledgePracticeService;

    @Autowired
    public InfectedKnowledgePracticeController (InfectedKnowledgePracticeService infectedKnowledgePracticeService) {
        this.infectedKnowledgePracticeService = infectedKnowledgePracticeService;
    }

    @PostMapping
    public ResponseEntity<List<InfectedKnowledgePracticeResponseDTO>> distributeCustom (
            @RequestBody InfectedKnowledgePracticeDistributionDTO dto
            )
    {
        List<InfectedKnowledgePracticeResponseDTO> response =
                infectedKnowledgePracticeService.applyKnowledgePracticePoints(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
