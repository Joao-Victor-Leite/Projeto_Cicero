package com.duende.cicero_app.controller.infected;


import com.duende.cicero_app.dto.infected.InfectedInstinctDistributionDTO;
import com.duende.cicero_app.dto.infected.InfectedInstinctResponseDTO;
import com.duende.cicero_app.service.infected.InfectedInstinctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infected-instinct")
public class InfectedInstinctController {

    public final InfectedInstinctService infectedInstinctService;

    @Autowired
    public InfectedInstinctController (InfectedInstinctService infectedInstinctService) { this.infectedInstinctService = infectedInstinctService; }

    @PostMapping
    public ResponseEntity<List<InfectedInstinctResponseDTO>> distributeCustom (
            @RequestBody InfectedInstinctDistributionDTO dto
            ) {
        List<InfectedInstinctResponseDTO> response = infectedInstinctService.applyDistribution(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
