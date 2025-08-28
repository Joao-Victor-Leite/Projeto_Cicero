package com.duende.cicero_app.controller.origin;

import com.duende.cicero_app.dto.origin.occupation.OccupationCreateDTO;
import com.duende.cicero_app.dto.origin.occupation.OccupationResponseDTO;
import com.duende.cicero_app.service.origin.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/occupation")
public class OccupationController {

    private final OccupationService occupationService;

    @Autowired
    public OccupationController (OccupationService occupationService) { this.occupationService = occupationService; }

    @GetMapping
    public ResponseEntity<List<OccupationResponseDTO>> findAll () {
        List<OccupationResponseDTO> occupation = occupationService.findAllOccupations();
        return ResponseEntity.status(HttpStatus.OK).body(occupation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccupationResponseDTO> findById (@PathVariable Short id) {
        OccupationResponseDTO occupation = occupationService.findOccupationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(occupation);
    }

    @PostMapping
    public ResponseEntity<OccupationCreateDTO> create (@RequestBody OccupationCreateDTO dto) {
        occupationService.createOccupation(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OccupationResponseDTO> update (@PathVariable Short id,
                                                         @RequestBody OccupationCreateDTO dto) {
        occupationService.updateOccupation(id, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Short id) {
        try {
            occupationService.deleteOccupation(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ocupação deletada");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
