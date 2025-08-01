package com.duende.cicero_app.controller;

import com.duende.cicero_app.dto.feat.FeatCreateDTO;
import com.duende.cicero_app.dto.feat.FeatResponseDTO;
import com.duende.cicero_app.service.FeatService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<FeatResponseDTO> findById(@PathVariable Long id) {
        FeatResponseDTO feat = featService.findFeatById(id);
        return ResponseEntity.status(HttpStatus.OK).body(feat);
    }

    @PostMapping
    public ResponseEntity<FeatResponseDTO> create(@RequestBody FeatCreateDTO dto) {
        FeatResponseDTO response = featService.createFeat(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatResponseDTO> update(@PathVariable Long id, @RequestBody FeatCreateDTO dto) {
        FeatResponseDTO featUpdated = featService.updateFeat(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(featUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            featService.deleteFeat(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Habilidade deletada");
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
