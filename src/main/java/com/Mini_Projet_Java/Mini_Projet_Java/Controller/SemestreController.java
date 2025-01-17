package com.Mini_Projet_Java.Mini_Projet_Java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Semestre;
import com.Mini_Projet_Java.Mini_Projet_Java.Service.SemestreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/semestres", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    // Récupérer tous les semestres
    @GetMapping
    public ResponseEntity<List<Semestre>> getAllSemestres() {
        List<Semestre> semestres = semestreService.getAllSemestres();
        return ResponseEntity.ok(semestres);
    }

    // Récupérer un semestre par ID
    @GetMapping("/{id}")
    public ResponseEntity<Semestre> getSemestreById(@PathVariable Long id) {
        Optional<Semestre> semestre = semestreService.getSemestreById(id);
        return semestre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ajouter ou mettre à jour un semestre
    @PostMapping(value="add",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Semestre> saveOrUpdateSemestre(@RequestBody Semestre semestre) {
        Semestre savedSemestre = semestreService.saveOrUpdateSemestre(semestre);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSemestre);
    }

    // Supprimer un semestre par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.noContent().build();
    }
}
