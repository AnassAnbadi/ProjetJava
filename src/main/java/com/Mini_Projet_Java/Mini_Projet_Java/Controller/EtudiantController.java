package com.Mini_Projet_Java.Mini_Projet_Java.Controller;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;
import com.Mini_Projet_Java.Mini_Projet_Java.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@CrossOrigin(origins = "http://localhost:3000") // Frontend autorisé
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Etudiant> getEtudiantByCode(@PathVariable Long code) {
        Etudiant etudiant = etudiantService.getEtudiantByCode(code);
        return etudiant != null ? ResponseEntity.ok(etudiant) : ResponseEntity.notFound().build();
    }

    @PostMapping("add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long code, @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(code, etudiant);
        return updatedEtudiant != null ? ResponseEntity.ok(updatedEtudiant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long code) {
        return etudiantService.deleteEtudiant(code) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
    //
    @GetMapping("/EtudiantListByElement")
    public List<Etudiant> getEtudiantsByProfesseur_Element(@RequestParam Long professeurId,@RequestParam Long ElementId) {
        return etudiantService.getEtudiantsByProfesseur_Element(professeurId, ElementId);
    }
}
