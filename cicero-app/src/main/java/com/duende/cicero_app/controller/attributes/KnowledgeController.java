package com.duende.cicero_app.controller.attributes;


import com.duende.cicero_app.dto.attribute.knowledge.KnowledgeResponseDTO;
import com.duende.cicero_app.service.attribute.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    @Autowired
    public KnowledgeController(KnowledgeService knowledgeService) { this.knowledgeService = knowledgeService; }

    @GetMapping
    public ResponseEntity<List<KnowledgeResponseDTO>> findAll() {
        List<KnowledgeResponseDTO> knowledge = knowledgeService.findAllKnowledge();
        return ResponseEntity.status(HttpStatus.OK).body(knowledge);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KnowledgeResponseDTO> findById(@PathVariable Long id) {
        KnowledgeResponseDTO knowledge = knowledgeService.findKnowledgeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(knowledge);
    }
}
