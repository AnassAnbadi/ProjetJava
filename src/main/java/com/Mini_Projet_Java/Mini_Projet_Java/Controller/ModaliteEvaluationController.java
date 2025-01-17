package com.Mini_Projet_Java.Mini_Projet_Java.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.ModaliteEvaluation;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ModaliteElementDTO;
import com.Mini_Projet_Java.Mini_Projet_Java.Service.ModaliteEvaluationService;

@RestController
@RequestMapping("/api/modalites")
public class ModaliteEvaluationController {

    @Autowired
    private ModaliteEvaluationService modaliteEvaluationService;


    
    
    @PostMapping("/SaveAllModalite")
    public ResponseEntity<List<ModaliteEvaluation>> saveAllModalites(
            @RequestBody List<ModaliteEvaluation> modalites) {
        List<ModaliteEvaluation> savedModalites = modaliteEvaluationService.saveAllModalites(modalites);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedModalites);
    }
    
    @PutMapping("/UpdateAllModalite")
    public ResponseEntity<List<ModaliteEvaluation>> updateAllModalites(
            @RequestBody List<ModaliteEvaluation> modalites) {
        List<ModaliteEvaluation> savedModalites = modaliteEvaluationService.updateAllModalites(modalites);
        return ResponseEntity.ok(savedModalites);
    }
    
    @GetMapping("/ForElement")
    public ResponseEntity<List<ModaliteElementDTO>> getModalitesByElementId(@RequestParam Long elementId) {
        List<ModaliteElementDTO> modalites = modaliteEvaluationService.getModalitesByElementId(elementId);
        if (modalites.isEmpty()) {
            return ResponseEntity.noContent().build(); // Renvoie 204 No Content si aucune donnée trouvée
        }
        return ResponseEntity.ok(modalites); // Renvoie 200 OK avec les données
    }
    
}
