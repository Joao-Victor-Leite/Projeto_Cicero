package com.duende.cicero_app.controller;

import com.duende.cicero_app.dto.feat.FeatResponseDTO;
import com.duende.cicero_app.service.FeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feat")
public class FeatController {

    private final FeatService featService;

    @Autowired
    public FeatController(FeatService featService) { this.featService = featService; }

    @GetMapping
    public ResponseEntity<List<FeatResponseDTO>> findAll() {
        List<FeatResponseDTO> feats = featService.findAllFeats();
        return ResponseEntity.status(HttpStatus.OK).body(feats);
    }


}
