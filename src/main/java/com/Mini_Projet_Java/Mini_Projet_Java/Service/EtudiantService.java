package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Filiere;
import com.Mini_Projet_Java.Mini_Projet_Java.Model.Semestre;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.EtudiantDTO;

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

	    @Autowired
	    private FiliereService filiereService;

	    @Autowired
	    private SemestreService semestreService;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
    

    // Méthode de conversion des étudiants en DTOs
    public List<EtudiantDTO> getAllEtudiantsDto() {
        List<Etudiant> etudiants = getAllEtudiants();
        
        return etudiants.stream()
                .map(etudiant -> new EtudiantDTO(
                        etudiant.getId(),
                        etudiant.getNomEtudiant(),
                        etudiant.getPrenomEtudiant(),
                        etudiant.getFiliere().getNomFiliere(),  // Assuming Filiere has a getNomFiliere() method
                        etudiant.getSemestre().getNom()  // Assuming Semestre has a getNomSemestre() method
                ))
                .collect(Collectors.toList());
    }

    public Etudiant getEtudiantByCode(Long code) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(code);
        
        return etudiant.orElse(null);
    }


    public EtudiantDTO addEtudiant(EtudiantDTO etudiantDTO) {
        Filiere f = filiereService.findByNom(etudiantDTO.getNomFiliere());
        Semestre s = semestreService.findByNom(etudiantDTO.getNomSemestre());
        Filiere filiere =new Filiere();
        Semestre semestre =new Semestre();

        filiere.setId(f.getId());
        semestre.setId(s.getId());
        
        if (filiere.getId() == null || semestre.getId() == null) {
            throw new RuntimeException("Filiere ou Semestre introuvable !");
        }

        // Conversion de EtudiantDTO en Etudiant
        Etudiant etudiant = new Etudiant(
                etudiantDTO.getNomEtudiant(),
                etudiantDTO.getPrenomEtudiant(),
                filiere,
                semestre
        );
        etudiant=etudiantRepository.save(etudiant);
        EtudiantDTO etudiantDTO2 =new EtudiantDTO(etudiant.getId(),
                etudiant.getNomEtudiant(),
                etudiant.getPrenomEtudiant(),
                etudiantDTO.getNomFiliere(),  // Assuming Filiere has a getNomFiliere() method
                etudiantDTO.getNomSemestre());
        
        return etudiantDTO2;
    }

    public EtudiantDTO updateEtudiant(Long code, EtudiantDTO updatedEtudiant) {
        if (etudiantRepository.existsById(code)) {
            updatedEtudiant.setId(code);
            
            Filiere f = filiereService.findByNom(updatedEtudiant.getNomFiliere());
            Semestre s = semestreService.findByNom(updatedEtudiant.getNomSemestre());
            Filiere filiere =new Filiere();
            Semestre semestre =new Semestre();

            filiere.setId(f.getId());
            semestre.setId(s.getId());
            
            if (filiere.getId() == null || semestre.getId() == null) {
                throw new RuntimeException("Filiere ou Semestre introuvable !");
            }

            // Conversion de EtudiantDTO en Etudiant
            Etudiant etudiant = new Etudiant(updatedEtudiant.getId(),
            		updatedEtudiant.getNomEtudiant(),
            		updatedEtudiant.getPrenomEtudiant(),
                    filiere,
                    semestre
            );
            etudiant=etudiantRepository.save(etudiant);
            EtudiantDTO etudiantDTO2 =new EtudiantDTO(etudiant.getId(),
                    etudiant.getNomEtudiant(),
                    etudiant.getPrenomEtudiant(),
                    etudiant.getFiliere().getNomFiliere(),  // Assuming Filiere has a getNomFiliere() method
                    etudiant.getSemestre().getNom());
            return etudiantDTO2;
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
