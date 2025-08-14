package com.duende.cicero_app.controller.item;

import com.duende.cicero_app.dto.item.quality.QualityResponseDTO;
import com.duende.cicero_app.service.item.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quality")
public class QualityController {

    private final QualityService qualityService;

    @Autowired
    public QualityController(QualityService qualityService) {
        this.qualityService = qualityService;
    }

    @GetMapping
    public ResponseEntity<List<QualityResponseDTO>> findAll() {
        List<QualityResponseDTO> qualities = qualityService.findAllQualities();
        return ResponseEntity.status(HttpStatus.OK).body(qualities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualityResponseDTO> findById(@PathVariable Long id) {
        QualityResponseDTO quality = qualityService.findQualityById(id);
        return ResponseEntity.status(HttpStatus.OK).body(quality);
    }

}
