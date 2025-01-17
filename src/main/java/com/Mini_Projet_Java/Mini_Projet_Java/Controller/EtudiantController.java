package com.Mini_Projet_Java.Mini_Projet_Java.Controller;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;

import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.EtudiantDTO;

import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.EtudiantForProfDTO;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.StudentDTO;

import com.Mini_Projet_Java.Mini_Projet_Java.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin(origins = "http://localhost:3000")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("get")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }
    
    @GetMapping("/dto")
    public List<EtudiantDTO> getAllEtudiantsDTO() {
        return etudiantService.getAllEtudiantsDto();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Etudiant> getEtudiantByCode(@PathVariable Long code) {
        Etudiant etudiant = etudiantService.getEtudiantByCode(code);
        return etudiant != null ? ResponseEntity.ok(etudiant) : ResponseEntity.notFound().build();
    }
    

    @PostMapping("add")
    public EtudiantDTO addEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        return etudiantService.addEtudiant(etudiantDTO);
    }

    @PutMapping("/{code}")
    public ResponseEntity<EtudiantDTO> updateEtudiant(@PathVariable Long code, @RequestBody EtudiantDTO etudiant) {
        EtudiantDTO updatedEtudiant = etudiantService.updateEtudiant(code, etudiant);
        return updatedEtudiant != null ? ResponseEntity.ok(updatedEtudiant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long code) {
        return etudiantService.deleteEtudiant(code) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
    //

    @GetMapping("/getStudentsByElement")
    public ResponseEntity<List<StudentDTO>> getStudentsByElement(@RequestParam Long elementId,@RequestParam Long modaliteId) {
        List<StudentDTO> students = etudiantService.getStudentsByElementId(elementId,modaliteId);
        return ResponseEntity.ok(students);
    }
}
