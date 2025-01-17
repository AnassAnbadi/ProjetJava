package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.EtudiantForProfDTO;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.StudentDTO;
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
    
    public List<StudentDTO> getStudentsByElementId(Long elementId,Long modaliteId) {
    	List<StudentDTO>l=etudiantRepository.findStudentsWithGradesByElementId(elementId,modaliteId);
    	for (StudentDTO s:l) {
    	System.out.println();
    	}
        return etudiantRepository.findStudentsWithGradesByElementId(elementId,modaliteId);
    }
    
    

}
