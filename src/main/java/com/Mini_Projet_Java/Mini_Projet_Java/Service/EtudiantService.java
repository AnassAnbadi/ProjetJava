package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.EtudiantDTO;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantByCode(Long code) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(code);
        
        return etudiant.orElse(null);
    }

    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Long code, Etudiant updatedEtudiant) {
        if (etudiantRepository.existsById(code)) {
            updatedEtudiant.setId(code);
            return etudiantRepository.save(updatedEtudiant);
        }
        return null;
    }

    public boolean deleteEtudiant(Long code) {
        if (etudiantRepository.existsById(code)) {
            etudiantRepository.deleteById(code);
            return true;
        }
        return false;
    }
    
    //list etudiant by prof et element
   // public List<Etudiant> getEtudiantsByProfesseur_Element(Long professeurId,Long ElementId) {
       // return etudiantRepository.findEtudiantsByProfesseurIdElementId(professeurId,ElementId);
    //}
    public List<EtudiantDTO> findEtudiantsByProfesseurIdElementId(Long professeurId, Long elementId) {
        List<Etudiant> etudiants = etudiantRepository.findEtudiantsByProfesseurIdElementId(professeurId, elementId);
        return etudiants.stream()
                        .map(e -> new EtudiantDTO(e.getId(), e.getNomEtudiant(), e.getPrenomEtudiant(),e.getFiliere().getId(),e.getSemestre().getId()))
                        .collect(Collectors.toList());
    }

}
